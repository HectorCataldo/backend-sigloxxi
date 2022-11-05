package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Orden_de_Compra;

@Repository
public interface DocumentoVentaRepository extends JpaRepository<Orden_de_Compra,Integer> {
}
