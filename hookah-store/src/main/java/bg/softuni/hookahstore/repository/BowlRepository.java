package bg.softuni.hookahstore.repository;

import bg.softuni.hookahstore.model.Bowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlRepository extends JpaRepository<Bowl, Long> {
}
