package cotato.hackathon.team1.domain.repository;

import cotato.hackathon.team1.domain.entity.Location;
import cotato.hackathon.team1.domain.entity.Quest;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {

    List<Quest> findAllByLocationId(Long id);
}
