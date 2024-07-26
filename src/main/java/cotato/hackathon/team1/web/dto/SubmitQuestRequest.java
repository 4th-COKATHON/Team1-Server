package cotato.hackathon.team1.web.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record SubmitQuestRequest(
        @NotNull
        Long userId,
        @NotNull
        Long questId,
        @NotNull
        MultipartFile image
) {
}
