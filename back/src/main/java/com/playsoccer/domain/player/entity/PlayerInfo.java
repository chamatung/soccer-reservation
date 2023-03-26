package com.playsoccer.domain.player.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@DynamicInsert//ColumnDefault 컬럼을 적용시키기 위해
public class PlayerInfo {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Player player; //선수
//    @ColumnDefault("비기너")
//    @Column(length = 15)
//    private String level1;
    @Column(nullable = false)
    private int carrer;
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



}
