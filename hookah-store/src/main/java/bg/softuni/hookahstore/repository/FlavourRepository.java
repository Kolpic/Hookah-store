package bg.softuni.hookahstore.repository;

import bg.softuni.hookahstore.model.Flavour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavourRepository extends JpaRepository<Flavour, Long> {
}
