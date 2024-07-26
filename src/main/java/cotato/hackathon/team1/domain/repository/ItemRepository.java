package cotato.hackathon.team1.domain.repository;

import cotato.hackathon.team1.domain.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByQuantityGreaterThan(Long quantity);
}
