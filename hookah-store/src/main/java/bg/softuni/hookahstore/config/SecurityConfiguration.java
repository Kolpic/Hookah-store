package bg.softuni.hookahstore.config;

import bg.softuni.hookahstore.enums.Role;
import bg.softuni.hookahstore.repository.UserRepository;
import bg.softuni.hookahstore.service.UserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
           SecurityContextRepository securityContextRepository) throws Exception {
        http.
                // defines which pages will be authorized
                        authorizeHttpRequests().
                // gives permission to static files(css, html, img) by everyone
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                // for who will be available this urls -> for everyone aka everyone has access to login and register page
                        requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll().
                // we give only admins access to admins page
                        requestMatchers("/addHookah", "/addBowl", "/addFlavour").hasRole(Role.ADMIN.name()).
                anyRequest().
                authenticated().
                and().
                // configure the login form
                        formLogin().
                // give the login page url
                        loginPage("/users/login").
                // get username and password
                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                // if we login successful we go to home page, if not we go login-error page
                        defaultSuccessUrl("/").
                // if we fail to log we go here
                        failureForwardUrl("/users/login-error").
                // configure logout
                        and().logout().
                logoutUrl("/users/logout").
                logoutSuccessUrl("/").
                invalidateHttpSession(true).
                and().
                // info for this part in the chain in doc for bean number four
                securityContext().securityContextRepository(securityContextRepository);

        return http.build();
    }

    // bean to crypt the password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // spring doesnt know about the current logged user, it cant understand what it is (it can be something else)
    // so we use this bean to configure the current logged user
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailService(userRepository);
    }

    // from migration spring security 5 to ss6
    // for every http request from userService(authentication) we have to put in SecurityContext, we put it throw
    // SecurityContextRepository that's why we have to expose this bean. To save userService(authentication) in SecurityContextRepository
    @Bean
    public SecurityContextRepository contextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
}
