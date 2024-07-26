package cotato.hackathon.team1.domain.entity;

import cotato.hackathon.team1.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String name;

    @Column(name = "item_point", nullable = false)
    private Long point;

    @Column(name = "item_quantity", nullable = false)
    private Long quantity;

    @Builder
    public Item(String name, Long point, Long quantity) {
        this.name = name;
        this.point = point;
        this.quantity = quantity;
    }
// 수량 있음?
    // 모든 지역 동일? 구분 기준 있음 따로?
}
