package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Integer> {
}
