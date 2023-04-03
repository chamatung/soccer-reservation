package com.playsoccer.domain.game.repository;

import com.playsoccer.domain.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long>, GameCustomRepository {
    List<Game> findByGameDayAndGameMonthAndGameYear(String day, String month, String year);
}
