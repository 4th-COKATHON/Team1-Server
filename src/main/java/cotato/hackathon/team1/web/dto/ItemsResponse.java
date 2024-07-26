package cotato.hackathon.team1.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record ItemsResponse(
        @Schema(name = "아이템 목록")
        List<ItemResponse> items
) {
}
