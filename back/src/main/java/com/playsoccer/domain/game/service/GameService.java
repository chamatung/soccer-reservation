package com.playsoccer.domain.game.service;

import com.playsoccer.domain.game.dto.DateDTO;
import com.playsoccer.domain.game.dto.GameDTO;
import com.playsoccer.domain.game.repository.GameRepository;
import com.playsoccer.domain.gameApply.repository.GameApplyRepository;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.repository.PlayerRepository;
import com.playsoccer.domain.stadium.dto.StadiumDTO;
import com.playsoccer.domain.stadium.entity.Stadium;
import com.playsoccer.domain.stadium.repository.StadiumRepository;
import com.playsoccer.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final StadiumRepository stadiumRepository;
    private final GameScheduleService gameInsertService;
    private final PlayerRepository playerRepository;

    //스케줄러용 구장 경기생성
    @Transactional
    public void allStadiumGameCreate() {
        /*
        * 1. 전체 구장리스트 가져오기
        * 2. 구장기준 game table where year and month 리스트 가져오기
        * -> createGameStadium메소드를 통해 1번리스트 기준으로 2번 list에 해당하지 않는 구장정보 return
        * 3. 이번달, 다음달 createList 영업시간 기준 전체 추가
        * 4. 스케줄은 약 1개월 마다 진행
        */

        DateDTO date = new DateDTO();

        List<StadiumDTO> stadiumList = stadiumRepository.findStadiumList(); // 전체리스트

        List<Long> gameStadiumList = gameRepository.findStadiumGame(date.getNowYear(),date.getNowMonth()); //이번달 등록된 게임구장 리스트
        List<Long> nextGameStadiumList = gameRepository.findStadiumGame(date.getNextYear(),date.getNextMonth()); //다음달 등록된 게임구장 리스트

        List<StadiumDTO> createGameList = checkStadiumList(stadiumList, gameStadiumList);//이번달 생성 구장리스트
        List<StadiumDTO> createNextGameList = checkStadiumList(stadiumList, nextGameStadiumList);//다음달 생성 구장리스트

        List<GameDTO> gameList = sumGameList(createGameList,createNextGameList, date);

        gameRepository.insertGameList(gameList);
    }

    private List<GameDTO> sumGameList(List<StadiumDTO> gameList, List<StadiumDTO> nextGameList, DateDTO date) {
        List<GameDTO> createGameList = new ArrayList<>();

        //이번달 구장 경기생성
        if(!CollectionUtils.isEmpty(gameList)){
            for(StadiumDTO stadium: gameList) {
                createGameList.addAll(gameInsertService.stadiumListGameInsert(date.getNowYear(),date.getNowMonth(),date.getNowDay(),stadium));
            }
        }
        //다음달 구장 경기생성
        if(!CollectionUtils.isEmpty(nextGameList)){
            for(StadiumDTO stadium: nextGameList) {
                createGameList.addAll(gameInsertService.stadiumListGameInsert(date.getNextYear(),date.getNextMonth(),1,stadium));
            }
        }

        return createGameList;
    }

    //관리자 회원가입 또는 관리자 변경시 게임생성 구장리스트 (단, 게임이 없는 경우)
    private ArrayList<StadiumDTO> checkStadiumList(List<StadiumDTO> stadiumList, List<Long> gameStadiumList) {

        ArrayList<StadiumDTO> list = new ArrayList<>();
        for(StadiumDTO stadium : stadiumList) {
            int cnt = 0;
            for(Long gameStadiumId : gameStadiumList) {
                if(stadium.getFieldId() == gameStadiumId) {
                    break;
                }else {
                    cnt++;
                }
            }
            if(gameStadiumList.size() == cnt) {
                list.add(stadium);
            }
        }
        return list;
    }

    public void createGameStadiumOne(Stadium stadium) {
        /*
        * 1.구장등록 시  게임 추가
        * 2. 금일기준부터 다음달 말일까지
        * */
        List<GameDTO> createGameList = new ArrayList<>();

        DateDTO date = new DateDTO();
        StadiumDTO stadiumDto = StadiumDTO.from(stadium);

        createGameList.addAll(gameInsertService.stadiumListGameInsert(date.getNowYear(),date.getNowMonth(),date.getNowDay(),stadiumDto)); //이번달
        createGameList.addAll(gameInsertService.stadiumListGameInsert(date.getNextYear(),date.getNextMonth(),1,stadiumDto)); //다음달

        gameRepository.insertGameList(createGameList);
    }

    @Transactional
    public List<GameDTO> findGameList(String day, String month, String year) {
        String username = SecurityUtil.getCurrentUsername().get();
        Player player = playerRepository.findByEmail(username);
        allStadiumGameCreate();
        changeGameAvailability(); //현재 시간 기준 이전 게임들 숨김처리

        Long playerId = player.getId();
        List<GameDTO> list = gameRepository.findGameList(day,month,year,playerId);

        return CollectionUtils.isEmpty(list) ? new ArrayList<>() : list;
    }

    public void changeGameAvailability() {

        LocalDateTime now = LocalDateTime.now();

        String nowYear = String.valueOf(now.getYear());
        String nowMonth = String.valueOf(now.getMonthValue());
        String nowDay = String.valueOf(now.getDayOfMonth());

        int nowTime = now.getHour();

        gameRepository.changeGameAvailability(nowDay, nowMonth, nowYear, nowTime);
    }

}
