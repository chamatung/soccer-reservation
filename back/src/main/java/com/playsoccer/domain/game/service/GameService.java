package com.playsoccer.domain.game.service;

import com.playsoccer.domain.game.dto.GameDTO;
import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.game.repository.GameRepository;
import com.playsoccer.domain.stadium.dto.StadiumDTO;
import com.playsoccer.domain.stadium.repository.StadiumRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final StadiumRepository stadiumRepository;
    private final GameInsertService gameInsertService;

    //스케줄러용 구장 경기생성
    @Transactional
    public void allStadiumGameCreate() {
        /*
        * 1. 전체 구장리스트 가져오기
        * 2. 구장기준 game table where year and month 리스트 가져오기
        * -> createGameStadium메소드를 통해 1번리스트 기준으로 2번 list에 해당하지 않는 구장정보 return
        * 3. 이번달, 다음달 createList 영업시간 기준 전체 추가
        * 4. 스케줄은 약 1개월 마다 진행하면 될 듯
        */
        LocalDate now = LocalDate.now();
        String nowYear = String.valueOf(now.getYear());
        String nowMonth = String.valueOf(now.getMonthValue());
        String nextYear = nowYear;
        String nextMonth = String.valueOf(now.getMonthValue() + 1);

        int nowDay = now.getDayOfMonth();

        //이번달 12월인 경우 다음달 년도와 달 변경
        if(StringUtils.equals("12", nowMonth)) {
            nextYear = String.valueOf(now.getYear() +1);
            nextMonth = "01";
        }

        List<StadiumDTO> stadiumList = stadiumRepository.findStadiumList(); // 전체리스트
        List<Long> gameStadiumList = gameRepository.findStadiumGame(nowYear,nowMonth); //이번달 등록된 게임구장 리스트
        List<Long> nextGameStadiumList = gameRepository.findStadiumGame(nextYear,nextMonth); //다음달 등록돈 게임구장 리스트

        List<StadiumDTO> createGameStadiumList = createGameStadium(stadiumList, gameStadiumList);//이번달 생성 구장리스트
        List<StadiumDTO> createNextGameStadiumList = createGameStadium(stadiumList, nextGameStadiumList);//다음달 생성 구장리스트

        //이번달 구장 경기생성
        if(!CollectionUtils.isEmpty(createGameStadiumList)){
            for(StadiumDTO stadium: createGameStadiumList) {
                gameInsertService.stadiumListGameInsert(nowYear,nowMonth,nowDay,stadium);
            }
        }
        //다음달 구장 경기생성
        if(!CollectionUtils.isEmpty(createNextGameStadiumList)){
            for(StadiumDTO stadium: createNextGameStadiumList) {
                gameInsertService.stadiumListGameInsert(nextYear,nextMonth,1,stadium);
            }
        }
    }
    //관리자 회원가입 또는 관리자 변경시 게임생성 구장리스트 (단, 게임이 없는 경우)
    private ArrayList<StadiumDTO> createGameStadium(List<StadiumDTO> stadiumList, List<Long> gameStadiumList) {
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

    public void stadiumGameCreate(String a) {
        /*
        * 1.구장등록 시  게임 추가
        * 2. 금일기준부터 다음달 말일까지
        * */
    }

    @Transactional
    public List<GameDTO> findGameList(String day, String month, String year) {
//        List<Game> list = gameRepository.findByGameDayAndGameMonthAndGameYear(day,month,year);
        changeGameAvailability();
        List<GameDTO> list = gameRepository.findGameList(day,month,year);


        return list;
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
