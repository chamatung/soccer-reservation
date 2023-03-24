package com.playsoccer.domain.gameApply.entity;

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
public class GameApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameApplyId;

    @ManyToOne
    @JoinColumn(name = "gameId")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "fieldId")
    private Stadium stadium;
}
