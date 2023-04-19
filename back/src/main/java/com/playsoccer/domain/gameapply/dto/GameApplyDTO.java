package com.playsoccer.domain.gameapply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class GameApplyDTO {
    private Long gameId;
    private Long fieldId;
    private Integer totalMember;
    private String gameDay;
    private Integer startTime;
    private String status;
    private String gameMonth;
    private String gameYear;
    private String gameAvailability;
    private String name;
    private Long gameApplyCnt;
    private String email;

}
