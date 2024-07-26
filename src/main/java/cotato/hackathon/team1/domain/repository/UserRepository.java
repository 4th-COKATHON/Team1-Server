package cotato.hackathon.team1.domain.repository;

import cotato.hackathon.team1.domain.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByKey(UUID uuid);
}
