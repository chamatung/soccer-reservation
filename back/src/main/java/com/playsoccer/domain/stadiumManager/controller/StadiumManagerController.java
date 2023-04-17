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

    /**
     * 관리자등록 및 등록일 기준 금월 명월 게임등록
     * @param {String} email;
     * @param {String} password;
     * @param {String} name;
     * @param {String} phone;
     * @param {String} address;
     * @param {String} addressDetail;
     * @param {String} managerLevel;
     * @param {String} stadiumName;
     * @param {String} stadiumArea;
     * @param {String} stadiumAddress;
     * @param {String} stadiumAddressDetail;
     * @param {String} workStartTime;
     * @param {String} workEndTime;
     * @param {String} fieldType;
     * @param {String} indoorStatus;
     * @return
     * */
    @PostMapping("/regist")
    public ResponseEntity<Map<String, String>> regist(@RequestBody(required = false) StadiumManagerDTO regist) {
        return stadiumMangerService.regist(regist);
    }

}
