package com.playsoccer.domain.stadiummanager.controller;

import com.playsoccer.domain.stadiummanager.dto.StadiumManagerDTO;
import com.playsoccer.domain.stadiummanager.service.StadiumMangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/s/stadiumManager")
public class StadiumManagerController {
    private final StadiumMangerService stadiumMangerService;

    /**
     * 이 메소드는 StadiumManagerDTO 객체를 매개변수로 받아 Map<String, String> 타입의 데이터를 ResponseEntity로 반환합니다.
     *
     * @param {StadiumManagerDTO} regist 회원가입 데이터를 담고 있는 StadiumManagerDTO 객체
     * @return {ResponseEntity<Map<String, String>>} ResponseEntity로 매핑된 Map<String,String> 객체
     * */
    @PostMapping("/regist")
    public ResponseEntity<Map<String, String>> regist(@RequestBody(required = false) StadiumManagerDTO regist) {
        return stadiumMangerService.regist(regist);
    }

}
