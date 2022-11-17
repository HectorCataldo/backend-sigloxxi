package restaurantSiglo.backend.repository;

import restaurantSiglo.backend.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
