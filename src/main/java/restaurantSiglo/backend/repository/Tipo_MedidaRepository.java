package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Tipo_Medida;

@Repository
public interface Tipo_MedidaRepository extends JpaRepository<Tipo_Medida,Integer> {

}
