package cotato.hackathon.team1.domain.service;

import cotato.hackathon.team1.domain.entity.Item;
import cotato.hackathon.team1.domain.repository.ItemRepository;
import cotato.hackathon.team1.web.dto.ItemResponse;
import cotato.hackathon.team1.web.dto.ItemsResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private static final Long DEFAULT_QUANTITY = 1L;
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public ItemsResponse findAllItems() {
        List<ItemResponse> itemResponses = itemRepository.findAllByQuantityGreaterThan(DEFAULT_QUANTITY).stream()
                .map(ItemResponse::from)
                .toList();

        return new ItemsResponse (itemResponses);
    }
}
