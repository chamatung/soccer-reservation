package com.playsoccer.domain.player.entity;


import com.playsoccer.domain.BaseEntity;
import com.playsoccer.domain.gameApply.entity.GameApply;
import com.playsoccer.domain.gameRecord.entity.GameRecord;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String name; //선수이름
    @Column(nullable = false)
    private LocalDate birth; //선수생일
    @Column(length = 100, nullable = false)
    private String email; //이메일
    @Column(length = 11, nullable = false)
    private String phone; //연락처
    @Column(length = 300, nullable = false)
    private String address; //주소
    @Column(length = 100, nullable = true)
    private String addressDetail; //상세주소

    @OneToMany(mappedBy = "player")
    private List<PlayerFavorArea> playerFavorAreaList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "player")
    private PlayerInfo playerInfo; //선수정보

    @OneToMany(mappedBy = "player")
    private List<GameApply> gameApplies = new ArrayList<>();

    @OneToMany(mappedBy = "player")
    private List<GameRecord> gameRecords = new ArrayList<>();


}
