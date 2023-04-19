package com.playsoccer.domain.gamerecord.entity;

import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.stadium.entity.Stadium;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRecord {

    @Id
    @ManyToOne
    @JoinColumn(name = "gameId")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "fieldId",nullable = false)
    private Stadium stadium;

    @Column(nullable = false)
    private Integer playScore;
    @Column(nullable = false)
    private Integer warn;

}