package bg.softuni.hookahstore.repository;

import bg.softuni.hookahstore.model.Hookah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HookahRepository extends JpaRepository<Hookah, Long> {

}
