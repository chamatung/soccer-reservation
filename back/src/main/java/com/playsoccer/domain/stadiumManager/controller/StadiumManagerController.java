package com.playsoccer.domain.stadiumManager.controller;

import com.playsoccer.domain.stadiumManager.dto.StadiumManagerDTO;
import com.playsoccer.domain.stadiumManager.service.StadiumMangerService;
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

    @PostMapping("/regist")
    public ResponseEntity<Map<String, String>> regist(@RequestBody(required = false) StadiumManagerDTO regist) {
        return stadiumMangerService.regist(regist);
    }

}
