package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
