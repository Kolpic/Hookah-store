package bg.softuni.hookahstore.web;

import bg.softuni.hookahstore.model.dto.UserRegistrationDTO;
import bg.softuni.hookahstore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;
    private final SecurityContextRepository securityContextRepository;

    public RegisterController(UserService userService, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.securityContextRepository = securityContextRepository;
    }

    @GetMapping("/users/register")
    public String register() {
        return "register";
    }

    @PostMapping("users/register")
    public String registerNewUser(UserRegistrationDTO userRegistrationDTO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        userService.registerUser(userRegistrationDTO, successfulAuth -> {
            // populating security context

            SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();

            // creates SecurityContext
            SecurityContext context = strategy.createEmptyContext();

            // setting authentication in SecurityContext
            context.setAuthentication(successfulAuth);

            strategy.setContext(context);

            // saving context in the securityContextRepository available after spring security 6
            securityContextRepository.saveContext(context, request, response);
        });

        return "redirect:/";
    }
}
