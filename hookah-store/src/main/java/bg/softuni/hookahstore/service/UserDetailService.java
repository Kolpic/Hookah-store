package bg.softuni.hookahstore.service;

import bg.softuni.hookahstore.model.UserRole;
import bg.softuni.hookahstore.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findUserEntityByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }
    // mapping provided by spring
    private UserDetails map(bg.softuni.hookahstore.model.User user) {
        return new User(
                user.getEmail(),
                user.getPassword(),
                extractAuthorities(user)
        );
    }

    // getting user roles
    private List<GrantedAuthority> extractAuthorities(bg.softuni.hookahstore.model.User user) {
        return user.
                getRoles().
                stream().
                map(this::mapRole).
                toList();
    }

    // getting the user role
    private GrantedAuthority mapRole(UserRole userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }
}
