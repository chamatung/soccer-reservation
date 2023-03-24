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
    private Integer totalMember;
    private LocalDate gameDate;
    private LocalDate startTime;
    private String status;

    @OneToMany(mappedBy = "game")
    private List<GameApply> gameApplies = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<GameRecord> gameRecords = new ArrayList<>();
}