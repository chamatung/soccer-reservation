package com.playsoccer.domain.stadium.dto;

import com.playsoccer.domain.game.dto.DateDTO;
import com.playsoccer.domain.stadium.entity.Stadium;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StadiumDTO {
    private Long fieldId;
    private String workStartTime;
    private String workEndTime;

    public static StadiumDTO from(Stadium stadium) {
        return new StadiumDTO(stadium.getFieldId(), stadium.getWorkStartTime(), stadium.getWorkEndTime());
    }
}
