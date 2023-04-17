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

    /**
    * 게임신청
    * @param {String} gameId;
    * @param {String} fieldId;
    * @param {Integer} totalMember;
    * @param {String} gameDay;
    * @param {Integer} startTime;
    * @param {String} status;
    * @param {String} gameMonth;
    * @param {String} gameYear;
    * @param {String} gameAvailability;
    * @param {String} name;
    * @param {int} gameApplyCnt;
    * @param {String} email;
    * @return
    */
    @PostMapping
    public ResponseEntity<Map<String,String>> addGameApply(@RequestBody GameApplyDTO apply) {
        return gameApplyService.addGameApply(apply);
    }

    /**
    * 게임신청 취소
    * @param {Long} gameId
    * @return
    */
    @PostMapping("/cancel") //deleteMapping 쓰면 기본적으로 RequestBody 못씀 설정해서 추가할 수 있다고 함, 아니면 pathVariable사용해야함
    public ResponseEntity<Map<String,String>> deleteGameApply(@RequestBody GameApplyDTO cancel) {
        return gameApplyService.deleteGameApply(cancel);
    }
}
