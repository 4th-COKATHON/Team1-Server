package cotato.hackathon.team1.domain.repository;

import cotato.hackathon.team1.domain.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {
}
