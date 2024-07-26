package cotato.hackathon.team1.domain.service;

import cotato.hackathon.team1.domain.entity.User;
import cotato.hackathon.team1.domain.repository.UserRepository;
import cotato.hackathon.team1.web.dto.AddEmailResponse;
import jakarta.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Long DEFAULT_POINT = 0L;
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Transactional
    public AddEmailResponse addUser(final String email) throws MessagingException {
        // 유저 존재 확인 -> 이미 존재 -> user_id 반환
        Optional<User> maybeUser = userRepository.findByEmail(email);

        if(maybeUser.isPresent()) {
            return AddEmailResponse.of(maybeUser.get());
        }

        // 존재하지 않아? 생성 + 이메일 보내기
        UUID key = createRandomAndUniqueKey();

        emailService.sendEmail(email, key);

        User createdUser = User.builder()
                .email(email)
                .key(key)
                .point(DEFAULT_POINT)
                .build();
        userRepository.save(createdUser);

        return AddEmailResponse.of(createdUser);
    }

    private UUID createRandomAndUniqueKey() {
        return UUID.randomUUID();
    }
}
