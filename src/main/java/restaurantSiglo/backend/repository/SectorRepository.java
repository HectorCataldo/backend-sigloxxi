package restaurantSiglo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantSiglo.backend.entities.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, String> {
}
