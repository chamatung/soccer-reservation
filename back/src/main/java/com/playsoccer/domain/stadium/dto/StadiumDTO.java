package com.playsoccer.domain.stadium.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StadiumDTO {
    private Long fieldId;
    private String workStartTime;
    private String workEndTime;

}
