package cotato.hackathon.team1.web.controller;

import cotato.hackathon.team1.domain.service.ItemService;
import cotato.hackathon.team1.web.dto.ItemsResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "모든 잔여 아이템 조회")
    @GetMapping
    public ResponseEntity<ItemsResponse> getItems() {
        return ResponseEntity.ok().body(itemService.findAllItems());
    }
}
