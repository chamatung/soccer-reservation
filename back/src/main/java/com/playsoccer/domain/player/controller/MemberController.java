package com.playsoccer.domain.player.controller;

import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/s/member")
public class MemberController {

    /*
        회원가입
     */
    @PostMapping("regist")
    public String regist(RegistDTO regist) {

        return "테스트 성공";
    }

    @PostMapping("login")
    public ResponseEntity<MultiValueMap<String, String>> signIn(@RequestBody(required = false) LoginDTO login) {
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("test1", "1111");
        header.add("test2", "2222");

        return new ResponseEntity<>(header, HttpStatus.OK);
    }

    @PostMapping("login1")
    public ResponseEntity<List<String>> test(@RequestBody(required = false) LoginDTO login) {
        List<String> response = new ArrayList<>();
        response.add("test1");
        response.add("test2");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
