package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
}
