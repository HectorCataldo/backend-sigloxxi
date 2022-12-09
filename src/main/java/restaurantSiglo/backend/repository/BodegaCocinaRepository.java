package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import restaurantSiglo.backend.entities.Bodega_Cocina;

import javax.transaction.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface BodegaCocinaRepository extends JpaRepository<Bodega_Cocina, Integer> {
}
