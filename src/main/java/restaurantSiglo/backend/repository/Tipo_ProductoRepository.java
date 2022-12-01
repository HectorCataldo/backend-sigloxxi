package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Tipo_Producto;

@Repository
public interface Tipo_ProductoRepository extends JpaRepository<Tipo_Producto, Integer> {

}
