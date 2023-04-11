package com.playsoccer.domain.game.repository;

import com.playsoccer.domain.game.dto.GameDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameCustomRepository {
    List<Long> findStadiumGame(String year, String month);

    void insertGameList(List<GameDTO> gameList);

    List<GameDTO> findGameList(String day, String month, String year, Long playerId);

    void changeGameAvailability(String nowDay, String nowMonth, String nowYear, int nowTime);

//    @Query(value = "select " +
//            "new com.playsoccer.domain.game.dto.GameDTO(" +
//            "game.gameId, game.stadium.fieldId, game.totalMember, game.gameDay, game.startTime, game.status, game.gameMonth, game.gameYear, game.gameAvailability, stadium.name," +
//            "(select count(gameApply) as gameApplyCnt from GameApply gameApply where gameApply.game.gameId = game.gameId)," +
//            "(select gameApply.player.email from GameApply gameApply where game.gameId = gameApply.game.gameId and gameApply.player.id =:playerId) )" +
//            "from Game game " +
//            "inner join Stadium  stadium on game.stadium.fieldId = stadium.fieldId " +
//            "where game.gameDay =:gameDay and game.gameMonth =:gameMonth and game.gameYear =:gameYear and game.gameAvailability =:availibility and game.status not in (:status)" +
//            "order by game.startTime asc, stadium.name asc")
//    public List<GameDTO> findGameListJpql(String gameDay, String gameMonth, String gameYear, String gameAvailibility, String status, Long playerId);
}
