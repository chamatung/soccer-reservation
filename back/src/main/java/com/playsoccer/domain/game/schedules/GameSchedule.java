package com.playsoccer.domain.game.schedules;

import com.playsoccer.domain.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GameSchedule {
    private final GameService gameService;

    /*
    * 게임 대량등록 매달 마지막날 03시 30분 게임등록
    * */
    @Scheduled(cron = "* 30 3 L * ?")
    public void gameCreate() {
        gameService.allStadiumGameCreate();
    }

    /*
    * 지난 게임 숨김처리 매일 홀수시간대 30분마다 마감처리
    * */
    @Scheduled(cron = "0 30 1-23/2 * * *")
    public void changeGameAvailability() {
        gameService.changeGameAvailability();
    }
}
