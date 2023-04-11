package com.playsoccer.domain.player.controller;

import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.PlayerInfoDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import com.playsoccer.domain.player.service.PlayerService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s/player")
public class PlayerController {

    private final PlayerService playerService;

    /*
        회원가입
     */
    @PostMapping("/regist")
    public ResponseEntity<Map<String, String>> regist(@RequestBody(required = false)RegistDTO regist) {
        return playerService.regist(regist);
    }
    //controller쪽 체크사항 service로 보내기
    @PostMapping("/signIn")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody(required = false) LoginDTO login) {
        return playerService.signIn(login);
    }

    @GetMapping("my-info")
    public PlayerInfoDTO findInfo(@RequestParam(name = "email")String email) {
        return playerService.findInfo(email);
    }
}
