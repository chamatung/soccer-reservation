package com.playsoccer.domain.game.schedules;

import com.playsoccer.domain.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GameSchedule {
    private final GameService gameService;

    @Scheduled(cron = "0 0 03 * * *")
    public void gameCreate() {

    }
}
