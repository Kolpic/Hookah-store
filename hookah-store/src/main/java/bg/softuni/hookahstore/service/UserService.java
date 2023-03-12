package bg.softuni.hookahstore.service;

import bg.softuni.hookahstore.enums.Role;
import bg.softuni.hookahstore.model.User;
import bg.softuni.hookahstore.model.dto.UserRegistrationDTO;
import bg.softuni.hookahstore.repository.UserRepository;
import bg.softuni.hookahstore.repository.UserRoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO,
                             Consumer<Authentication> successfulLoginProcessor) {

        var userRole = userRoleRepository.
                findUserRoleEntityByRole(Role.USER).
                orElseThrow();

        User userToRegister = new User().
                setFirstName(userRegistrationDTO.getFirstName()).
                setLastName(userRegistrationDTO.getLastName()).
                setEmail(userRegistrationDTO.getEmail()).
                setRoles(List.of(userRole)).
                setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        userRepository.save(userToRegister);

        var userDetails = userDetailsService.loadUserByUsername(userRegistrationDTO.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }
}
