package com.playsoccer.domain.player.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@DynamicInsert//ColumnDefault 컬럼을 적용시키기 위해
public class PlayerInfo {

    @Id
    private Long id;
    @Column(length = 15, nullable = true)
    private String level;
    @Column(nullable = false)
    private Integer carrer;
    @Column(length = 15, nullable = false)
    private String position;
    @Column(length = 10, nullable = false)
    private String playFoot;
    @Column(length = 5, nullable = false)
    private String weight;
    @Column(length = 5, nullable = false)
    private String height;
    @Column(length = 30, nullable = false)
    private String nation;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Player player; //선수

    public void changeId(Long id) {
        this.id = id;
    }

}
