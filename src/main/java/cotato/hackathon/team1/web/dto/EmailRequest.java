package cotato.hackathon.team1.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequest(
        @Email
        @NotBlank
        String email
) {
}
