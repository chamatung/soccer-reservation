package com.playsoccer.domain.game.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

@Getter
@Setter
public class DateDTO {

    private LocalDate now;
    private String nowYear;
    private String nowMonth;
    private int nowDay;
    private String nextYear;
    private String nextMonth;

    public DateDTO() {
        this.now = LocalDate.now();
        this.nowYear = String.valueOf(now.getYear());
        this.nowMonth = String.valueOf(now.getMonthValue());
        this.nowDay = now.getDayOfMonth();

        this.nextYear = nowYear;
        this.nextMonth = String.valueOf(now.getMonthValue() + 1);

        if(StringUtils.equals("12", this.nowMonth)) {
            this.nextYear = String.valueOf(this.now.getYear() +1);
            this.nextMonth = "01";
        }
    }

}
