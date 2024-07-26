package cotato.hackathon.team1.domain.entity;

import cotato.hackathon.team1.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_key", unique = true, nullable = false)
    private UUID key;

    @Column(name = "user_point", nullable = false)
    private Long point;

    @Builder
    public User(String email, UUID key, Long point) {
        this.email = email;
        this.key = key;
        this.point = point;
    }
}
