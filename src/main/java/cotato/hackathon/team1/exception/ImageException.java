package cotato.hackathon.team1.exception;

import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageException extends IOException {
    private ErrorCode errorCode;
}
