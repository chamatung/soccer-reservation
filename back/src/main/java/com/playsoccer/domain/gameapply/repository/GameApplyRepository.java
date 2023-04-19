package com.playsoccer.domain.gameapply.repository;

import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.gameapply.entity.GameApply;
import com.playsoccer.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameApplyRepository extends JpaRepository<GameApply, Long> {
    GameApply findByPlayerAndGame(Optional<Player> id, Optional<Game> gameId);
    int countByGame(Game game);
}
