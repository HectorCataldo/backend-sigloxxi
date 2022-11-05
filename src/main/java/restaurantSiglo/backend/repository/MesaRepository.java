package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa,Integer> {
}
