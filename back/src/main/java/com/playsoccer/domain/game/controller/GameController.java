package com.playsoccer.domain.game.controller;

import com.playsoccer.domain.game.dto.GameDTO;
import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.game.service.GameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s/game")
public class GameController {

    private final GameService gameService;

    @GetMapping("/list")
    public List<GameDTO> findGameList(@RequestParam String day, @RequestParam String month, @RequestParam String year) {
        return gameService.findGameList(day, month, year);
    }
}
