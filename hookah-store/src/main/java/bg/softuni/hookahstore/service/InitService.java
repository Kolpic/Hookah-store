package bg.softuni.hookahstore.service;

import bg.softuni.hookahstore.enums.Role;
import bg.softuni.hookahstore.model.User;
import bg.softuni.hookahstore.model.UserRole;
import bg.softuni.hookahstore.repository.UserRepository;
import bg.softuni.hookahstore.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public InitService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder,
                       @Value("${app.default.password}") String defaultPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    public void initRoles() {
        if (userRoleRepository.count() == 0) {
            var moderatorRole = new UserRole().setRole(Role.MODERATOR);
            var adminRole = new UserRole().setRole(Role.ADMIN);
            var userRole = new UserRole().setRole(Role.USER);

            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
        }
    }

    public void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }

    public void initAdmin() {
        var adminUser = new User().
                setEmail("admin@example.com").
                setFirstName("Admin").
                setLastName("Adminov").
                setPassword(passwordEncoder.encode("123456789")).
                setRoles(userRoleRepository.findAll());

        userRepository.save(adminUser);
    }

    public void initModerator() {

        var moderatorRole = userRoleRepository.
                findUserRoleEntityByRole(Role.MODERATOR).
                orElseThrow();

        var moderatorUser = new User().
                setEmail("moderator@example.com").
                setFirstName("Moderator").
                setLastName("Moderatorov").
                setPassword(passwordEncoder.encode("123456789")).
                setRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);
    }

    public void initNormalUser() {
        var normalUser = new User().
                setEmail("user@example.com").
                setFirstName("User").
                setLastName("Userov").
                setPassword(passwordEncoder.encode("123456789"));

        userRepository.save(normalUser);
    }
}
