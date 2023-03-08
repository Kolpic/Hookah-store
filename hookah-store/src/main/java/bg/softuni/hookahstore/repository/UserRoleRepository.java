package bg.softuni.hookahstore.repository;

import bg.softuni.hookahstore.enums.Role;
import bg.softuni.hookahstore.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findUserRoleEntityByRole(Role userRoleEnum);
}
