package cotato.hackathon.team1.web.dto;

import cotato.hackathon.team1.domain.entity.Item;
import io.swagger.v3.oas.annotations.media.Schema;

public record ItemResponse(
        @Schema(name = "아이템 PK")
        Long itemId,
        @Schema(name = "아이템 이름")
        String name,
        @Schema(name = "아이템 가격")
        Long point
) {
    public static ItemResponse from(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getPoint()
        );
    }
}
