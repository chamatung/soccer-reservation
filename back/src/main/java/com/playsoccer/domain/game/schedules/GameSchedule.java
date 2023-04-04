package com.playsoccer.domain.game.schedules;

import com.playsoccer.domain.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GameSchedule {
    private final GameService gameService;

    //게임 대량등록
//    @Scheduled(cron = "0 0 03 * * *")
//    @Scheduled(cron = "* * * * * *")
    public void gameCreate() {
        gameService.allStadiumGameCreate();
    }

    //지난 게임 숨김처리
    //@Scheduled(cron = "0 30 1-24/2 * * *")
//    public void changeGameAvailability() {
//        gameService.changeGameAvailability();
//    }
}
