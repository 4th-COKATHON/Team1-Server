package cotato.hackathon.team1.domain.service;

import cotato.hackathon.team1.domain.entity.User;
import cotato.hackathon.team1.domain.repository.UserRepository;
import cotato.hackathon.team1.web.dto.AddEmailResponse;
import cotato.hackathon.team1.web.dto.PointResponse;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional(readOnly = true)
    public PointResponse findUserPointByKey(final String key) {
        UUID uuid = UUID.fromString(key);
        User findUser = userRepository.findByKey(uuid)
                .orElseThrow(() -> new EntityNotFoundException("해당 키를 가진 고객을 찾을 수 없습니다."));

        return PointResponse.from(findUser);
    }
}
