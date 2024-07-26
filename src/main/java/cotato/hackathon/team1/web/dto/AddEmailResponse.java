package cotato.hackathon.team1.web.dto;

import cotato.hackathon.team1.domain.entity.User;

public record AddEmailResponse(
        Long userId
) {
    public static AddEmailResponse of(User user) {
        return new AddEmailResponse(user.getId());
    }
}
