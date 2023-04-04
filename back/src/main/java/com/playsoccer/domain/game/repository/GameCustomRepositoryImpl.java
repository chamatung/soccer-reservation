package com.playsoccer.domain.game.repository;

import com.playsoccer.domain.game.dto.GameDTO;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.playsoccer.domain.game.entity.QGame.game;
import static com.playsoccer.domain.gameApply.entity.QGameApply.gameApply;
import static com.playsoccer.domain.stadium.entity.QStadium.stadium;

@RequiredArgsConstructor
public class GameCustomRepositoryImpl implements GameCustomRepository{
    private final JPAQueryFactory querydsl;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Long> findStadiumGame(String year, String month) {
        List<Long> gameStadiumList = querydsl.select(
                        game.stadium.fieldId
                ).from(game)
                .where(game.gameYear.eq(year)
                        .and(game.gameMonth.eq(month)))
                //게임.금년 , 게임.금월, 명월 -> 금월이 12월이면 명월은 내년 1월
                .groupBy(stadium.fieldId).fetch();

        return gameStadiumList;
    }
    @Override
    public void insertGameList(List<GameDTO> gameList) {
        final String sql =
                "INSERT INTO GAME" +
                        "( game_availability, game_day, game_month, game_year, start_time, status, total_member, field_id)" +
                        "VALUES(?,?,?,?,?,?,?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, gameList.get(i).getGameAvailability());
                ps.setString(2, gameList.get(i).getGameDay());
                ps.setString(3, gameList.get(i).getGameMonth());
                ps.setString(4, gameList.get(i).getGameYear());
                ps.setInt(5, gameList.get(i).getStartTime());
                ps.setString(6, gameList.get(i).getStatus());
                ps.setInt(7, gameList.get(i).getTotalMember());
                ps.setLong(8, gameList.get(i).getFieldId());
            }

            @Override
            public int getBatchSize() {
                return gameList.size();
            }
        });
    }

    @Override
    public List<GameDTO> findGameList(String day, String month, String year, Long playerId) {


        return querydsl.select(Projections.constructor(
                GameDTO.class,
                game.gameId,
                game.stadium.fieldId,
                game.totalMember,
                game.gameDay,
                game.startTime,
                game.status,
                game.gameMonth,
                game.gameYear,
                game.gameAvailability,
                stadium.name,
                ExpressionUtils.as(
                        JPAExpressions.select(gameApply.count())
                                .from(gameApply)
                                .where(gameApply.game.gameId.eq(game.gameId)),
                        "gameApplyCnt"),
                ExpressionUtils.as(
                        JPAExpressions.select(gameApply.player.email)
                                .from(gameApply)
                                .where(game.gameId.eq(gameApply.game.gameId).and(gameApply.player.id.eq(playerId))),
                        "email"
                )
        )).from(game)
                .innerJoin(stadium)
                .on(game.stadium.fieldId.eq(stadium.fieldId))
                .where(game.gameDay.eq(day)
                        .and(game.gameMonth.eq(month))
                        .and(game.gameYear.eq(year))
                        .and(game.gameAvailability.eq("가능")))
                .orderBy(game.startTime.asc(), stadium.name.asc())
                .fetch();
    }


    @Override
    public void changeGameAvailability(String nowDay, String nowMonth, String nowYear, int nowTime) {
        querydsl.update(game).set(game.gameAvailability, "불가능")
                .where(game.startTime.loe(nowTime)
                        .and(game.gameDay.eq(nowDay))
                        .and(game.gameMonth.eq(nowMonth))
                        .and(game.gameYear.eq(nowYear)))
                .execute();

    }
}
