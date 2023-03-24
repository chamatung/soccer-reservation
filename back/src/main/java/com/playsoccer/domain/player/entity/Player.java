package com.playsoccer.domain.player.entity;


import com.playsoccer.domain.gameApply.entity.GameApply;
import com.playsoccer.domain.gameRecord.entity.GameRecord;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String name; //선수이름
    private LocalDate birth; //선수생일
    private String email; //이메일
    private String phone; //연락처
    private String address; //주소
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
