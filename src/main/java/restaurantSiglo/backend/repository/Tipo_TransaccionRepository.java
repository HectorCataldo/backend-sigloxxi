package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Tipo_Transaccion;

@Repository
public interface Tipo_TransaccionRepository extends JpaRepository<Tipo_Transaccion, String> {
}
