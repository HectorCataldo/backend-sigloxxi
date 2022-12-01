package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Tipo_Funcionario;

@Repository
public interface Tipo_FuncionarioRepository extends JpaRepository<Tipo_Funcionario, Integer> {
}
