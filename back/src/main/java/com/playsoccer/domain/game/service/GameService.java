package com.playsoccer.domain.game.service;

import com.playsoccer.domain.game.repository.GameRepository;
import com.playsoccer.domain.stadium.dto.StadiumDTO;
import com.playsoccer.domain.stadium.repository.StadiumRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final StadiumRepository stadiumRepository;

    @Transactional
    public void allStadiumGameCreate() {
        /*
        * 1. 구장리스트 left join 경기 is null이면서 이번달 , 다음달  그리고 그룹화
        * 2. 구장에 따른 게임이 있는지 체크하고 ( 각 구장별 체크 )
        * -> 체크 기준 이번달 기준 1개 이상 다음달 기준 1개 이상
        * 3. 없으면 해당 달에 대한 게임을 추가
        * 4. 추가 범위를 각 이번달 다음달로 나누기
        * 5. 스케줄은 매일 오전 03시에 동작
        */

        List<Long> stadiumList = stadiumRepository.findStadiumNotGame();

    }
    public void stadiumGameCreate(String a) {
        /*
        * 1.구장등록 시  게임 추가
        * 2. 금일기준부터 다음달 말일까지
        * */
    }
}
