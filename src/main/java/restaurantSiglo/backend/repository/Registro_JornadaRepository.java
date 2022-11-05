package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Registro_Jornada;

@Repository
public interface Registro_JornadaRepository extends JpaRepository<Registro_Jornada, Integer> {
}
