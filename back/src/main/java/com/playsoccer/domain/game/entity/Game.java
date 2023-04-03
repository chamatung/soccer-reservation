package com.playsoccer.domain.game.entity;

import com.playsoccer.domain.gameApply.entity.GameApply;
import com.playsoccer.domain.gameRecord.entity.GameRecord;
import com.playsoccer.domain.stadium.entity.Stadium;
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
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @ManyToOne(fetch = FetchType.LAZY) // 해당 경기 기준으로는 경기구장은 1개 근데 경기구장 기준으로는 oneToMany
    @JoinColumn(name = "fieldId")
    private Stadium stadium;
    @Column(nullable = false)
    private Integer totalMember;
    @Column(length = 2,nullable = false)
    private String gameDay;
    @Column(nullable = false)
    private Integer startTime;
    @Column(length = 15, nullable = false)
    private String status;

    @Column(length = 4, nullable = false)
    private String gameYear;
    @Column(length = 2, nullable = false)
    private String gameMonth;
    @Column(length = 10, nullable = false)
    private String gameAvailability;

//    @Column
//    @OneToMany(mappedBy = "game")
//    private List<GameApply> gameApplies = new ArrayList<>();
//
//    @OneToMany(mappedBy = "game")
//    private List<GameRecord> gameRecords = new ArrayList<>();

}
