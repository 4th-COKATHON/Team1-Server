package cotato.hackathon.team1.domain.repository;

import cotato.hackathon.team1.domain.entity.QuestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestHistoryRepository extends JpaRepository<QuestHistory, Long> {
}
