package com.playsoccer.domain.gameApply.repository;

import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.gameApply.entity.GameApply;
import com.playsoccer.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameApplyRepository extends JpaRepository<GameApply, Long> {
    GameApply findByPlayerId(Long id);
    GameApply findByPlayerAndGame(Optional<Player> id, Optional<Game> gameId);
    int countByGame(Game game);
}
