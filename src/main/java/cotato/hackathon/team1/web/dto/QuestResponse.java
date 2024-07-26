package cotato.hackathon.team1.web.dto;


import cotato.hackathon.team1.domain.entity.Quest;

public record QuestResponse(
        Long questId,
        String place,
        String how,
        String what
){
    public static QuestResponse from(Quest quest) {
        return new QuestResponse(
                quest.getId(),
                quest.getPlace(),
                quest.getHow(),
                quest.getWhat()
        );
    }
}
