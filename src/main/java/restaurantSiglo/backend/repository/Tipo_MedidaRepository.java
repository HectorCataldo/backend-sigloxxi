package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import restaurantSiglo.backend.entities.Tipo_Medida;

import javax.transaction.Transactional;

@Repository
@Transactional
@EnableTransactionManagement
public interface Tipo_MedidaRepository extends JpaRepository<Tipo_Medida,Integer> {

}
