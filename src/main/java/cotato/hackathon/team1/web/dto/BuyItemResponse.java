package cotato.hackathon.team1.web.dto;

import cotato.hackathon.team1.domain.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record BuyItemResponse(
        @Schema(name = "유저 PK")
        Long userId,
        @Schema(name = "사용 후 잔여 포인트")
        Long remainPoints
) {
        public static BuyItemResponse from(User findUser) {
                return new BuyItemResponse(
                        findUser.getId(),
                        findUser.getPoint()
                );
        }
}
