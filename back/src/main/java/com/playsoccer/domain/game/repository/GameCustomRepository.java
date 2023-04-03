package com.playsoccer.domain.game.repository;

import com.playsoccer.domain.game.dto.GameDTO;

import java.util.List;

public interface GameCustomRepository {
    List<Long> findStadiumGame(String year, String month);

    void insertGameList(List<GameDTO> gameList);

    List<GameDTO> findGameList(String day, String month, String year);

    void changeGameAvailability(String nowDay, String nowMonth, String nowYear, int nowTime);
}
