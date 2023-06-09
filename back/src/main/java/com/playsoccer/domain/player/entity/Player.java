package com.playsoccer.domain.player.entity;


import com.playsoccer.domain.gameapply.entity.GameApply;
import com.playsoccer.domain.gamerecord.entity.GameRecord;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "player")
    private PlayerInfo playerInfo; //선수정보

    @OneToMany(mappedBy = "player")
    private final List<PlayerFavorArea> playerFavorAreaList = new ArrayList<>();

    @OneToMany(mappedBy = "player")
    private final List<GameApply> gameApplies = new ArrayList<>();

    @OneToMany(mappedBy = "player")
    private final List<GameRecord> gameRecords = new ArrayList<>();

    @OneToMany(mappedBy = "player")
    private final Set<PlayerRole> playerRoleList = new HashSet<>();

}
