package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Tipo_Receta;

@Repository
public interface Tipo_RecetaRepository extends JpaRepository<Tipo_Receta, String> {
}
