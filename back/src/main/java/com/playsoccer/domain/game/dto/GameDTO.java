package com.playsoccer.domain.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
public class GameDTO {

    private Long fieldId;
    private Integer totalMember; //풋살밖에 안됌 대경기는 아예 구자예약을 하는 다른 시스템으로 만들것
    private String gameDay;
    private Integer startTime;
    private String status;
    private String gameMonth;
    private String gameYear;
    private String gameAvailability;
    private String name;
    private Long gameApplyCnt;

}


