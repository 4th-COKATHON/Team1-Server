package cotato.hackathon.team1.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    IMAGE_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 5001, "서버 이미지 처리 실패"),
    ;

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
