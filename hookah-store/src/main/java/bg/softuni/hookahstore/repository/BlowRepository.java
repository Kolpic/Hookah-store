package bg.softuni.hookahstore.repository;

import bg.softuni.hookahstore.model.Blow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlowRepository extends JpaRepository<Blow, Long> {
}
