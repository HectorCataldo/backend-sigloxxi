package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta,Integer> {
}
