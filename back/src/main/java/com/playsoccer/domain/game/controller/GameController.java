package com.playsoccer.domain.game.controller;

import com.playsoccer.domain.game.dto.GameDTO;
import com.playsoccer.domain.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s/games")
public class GameController {

    private final GameService gameService;

    /**
    * 일자 기준 게임리스트 조회
    * @param {String} day
    * @param {String} month
    * @param {String} year
    * @return
    * */
    @GetMapping
    public List<GameDTO> findGameList(@RequestParam String day, @RequestParam String month, @RequestParam String year) {
        return gameService.findGameList(day, month, year);
    }
}
