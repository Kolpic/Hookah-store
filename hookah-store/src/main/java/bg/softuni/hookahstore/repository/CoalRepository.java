package bg.softuni.hookahstore.repository;

import bg.softuni.hookahstore.model.Coal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoalRepository extends JpaRepository<Coal, Long> {
}
