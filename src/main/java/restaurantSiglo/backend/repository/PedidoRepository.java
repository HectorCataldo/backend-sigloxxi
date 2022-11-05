package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
