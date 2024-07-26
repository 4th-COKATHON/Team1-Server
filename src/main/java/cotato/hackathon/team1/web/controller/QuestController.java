package cotato.hackathon.team1.web.controller;

import cotato.hackathon.team1.common.exception.ImageException;
import cotato.hackathon.team1.domain.service.QuestService;
import cotato.hackathon.team1.web.dto.SubmitQuestRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quests")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @PostMapping(value = "/image",  consumes = "multipart/form-data")
    public ResponseEntity<Void> uploadImagesToQuest(@ModelAttribute SubmitQuestRequest request) throws ImageException {
        questService.submitQuest(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "장소별 퀘스트 조회 API", description = "장소에 해당하는 퀘스트 목록을 조회한다.")
    @GetMapping
    public ResponseEntity<?> getQuestsByLocation(@RequestParam("location") String location) {
        return ResponseEntity.ok().body(questService.findAllByLocation(location));
    }
}
