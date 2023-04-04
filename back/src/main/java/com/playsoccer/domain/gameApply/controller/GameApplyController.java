package com.playsoccer.domain.gameApply.controller;

import com.playsoccer.domain.gameApply.dto.GameApplyDTO;
import com.playsoccer.domain.gameApply.service.GameApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/s/game-apply")
@RestController
public class GameApplyController {

    private final GameApplyService gameApplyService;

    @PostMapping
    public ResponseEntity<Map<String,String>> addGameApply(@RequestBody GameApplyDTO apply) {
        return gameApplyService.addGameApply(apply);
    }

    @PostMapping("/cancel") //deleteMapping 쓰면 기본적으로 RequestBody 못씀 설정해서 추가할 수 있다고 함, 아니면 pathVariable사용해야함
    public ResponseEntity<Map<String,String>> deleteGameApply(@RequestBody GameApplyDTO cancel) {
        return gameApplyService.deleteGameApply(cancel);
    }
}
