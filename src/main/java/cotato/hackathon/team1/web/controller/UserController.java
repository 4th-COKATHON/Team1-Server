package cotato.hackathon.team1.web.controller;

import cotato.hackathon.team1.domain.service.UserService;
import cotato.hackathon.team1.web.dto.AddEmailResponse;
import cotato.hackathon.team1.web.dto.EmailRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 이메일 등록 API", description = "회원은 이메일을 등록 후 고유 키를 이메일로 전송 받는다.")
    @PostMapping("/add")
    public ResponseEntity<AddEmailResponse> addUserEmail(@RequestBody EmailRequest request) throws MessagingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(request.email()));
    }
}
