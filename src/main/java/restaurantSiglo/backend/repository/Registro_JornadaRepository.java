package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import restaurantSiglo.backend.entities.Registro_Jornada;

import javax.transaction.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface Registro_JornadaRepository extends JpaRepository<Registro_Jornada, Integer> {
}
