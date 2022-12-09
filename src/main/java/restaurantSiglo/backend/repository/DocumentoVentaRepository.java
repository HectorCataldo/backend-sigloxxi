package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import restaurantSiglo.backend.entities.Orden_de_Compra;

import javax.transaction.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface DocumentoVentaRepository extends JpaRepository<Orden_de_Compra,Integer> {
}
