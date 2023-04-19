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
import static com.playsoccer.domain.gameapply.entity.QGameApply.gameApply;
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

    /* 배치 사용이유

    첫번째) saveAll -> insert into 테이블(컬럼1, 2, 3~8)  valuse(값1, 값2~값8)
          SQL 1000번 실행

    두번째) jdbcTemplate batch -> insert into 테이블(컬럼1, 2, 3~8)  valuse(값1, 값2~값8) (값1, 값2~값8)
                            (값1, 값2~값8)..* 1000개
            SQL 1000개를 묶어서 1번 실행
    * */
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
                        .and(game.gameAvailability.eq("가능"))
                        .and(game.status.notIn("마감"))
                )

                .orderBy(game.startTime.asc(), stadium.name.asc())
                .fetch();
    }

/*
* lt < little

loe <= Less or Equal

gt > greater

goe >= greater or Equal

eq == Equal

jpql 검색조건방식 차이
member.username.eq("a") : username = 'a'
member.username.ne("a") : username ≠ 'a'
member.username.eq("a").not() : username ≠ 'a'
member.username.isNotNull() : username is not null
member.age.in(10,20) : age in (10,20)
member.age.notIn(10,20) : age not in(10,20)
member.age.between(10,30) : age between 10, 30
member.age.goe(30) : age ≥ 30
member.age.gt(30) : age > 30
member.age.loe(30) : age ≤ 30
member.age.lt(30) : age < 30
member.username.like("member%") : username like 'member%'
member.username.contains("member') : username like '%member%'
member.username.startsWith("member") : like 'member%'

* */
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
