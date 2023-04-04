package com.playsoccer.domain.gameApply.entity;

import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.stadium.entity.Stadium;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameApplyId;

    @ManyToOne
    @JoinColumn(name = "gameId",nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "fieldId",nullable = false)
    private Stadium stadium;
}
