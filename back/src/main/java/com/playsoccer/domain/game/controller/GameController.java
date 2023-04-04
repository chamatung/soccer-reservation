package com.playsoccer.domain.game.controller;

import com.playsoccer.domain.game.dto.GameDTO;
import com.playsoccer.domain.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s/games")
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<GameDTO> findGameList(@RequestParam String day, @RequestParam String month, @RequestParam String year, @RequestParam String email) {
        return gameService.findGameList(day, month, year, email);
    }


}
