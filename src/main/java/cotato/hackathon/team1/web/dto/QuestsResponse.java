package cotato.hackathon.team1.web.dto;

import java.util.List;

public record QuestsResponse(
        String locationName,
        List<QuestResponse> quests
) {

    public static QuestsResponse of(String locationName, List<QuestResponse> quests) {
        return new QuestsResponse(
                locationName,
                quests
        );
    }
}
