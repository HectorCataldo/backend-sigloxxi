package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
