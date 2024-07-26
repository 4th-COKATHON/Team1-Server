package cotato.hackathon.team1.web.dto;

import cotato.hackathon.team1.domain.entity.User;

public record PointResponse(
        Long userId,
        Long point
) {
    public static PointResponse from(User user) {
        return new PointResponse(
                user.getId(),
                user.getPoint()
        );
    }
}
