package cotato.hackathon.team1.domain.repository;

import cotato.hackathon.team1.domain.entity.Location;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(String locationName);
}
