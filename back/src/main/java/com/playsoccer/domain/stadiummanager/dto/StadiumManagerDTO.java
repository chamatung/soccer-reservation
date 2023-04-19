package com.playsoccer.domain.stadiummanager.dto;

import com.playsoccer.domain.stadium.entity.Stadium;
import com.playsoccer.domain.stadiummanager.entity.StadiumManager;
import lombok.Data;

@Data
public class StadiumManagerDTO {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String addressDetail;
    private String managerLevel;
    private String stadiumName;
    private String stadiumArea;
    private String stadiumAddress;
    private String stadiumAddressDetail;
    private String workStartTime;
    private String workEndTime;
    private String fieldType;
    private String indoorStatus;

    public StadiumManager toStadiumManager() {
        return StadiumManager.builder()
                .email(this.email)
                .pw(this.password)
                .name(this.name)
                .phone(this.phone)
                .address(this.address)
                .addressDetail(this.addressDetail)
                .managerLevel(this.managerLevel)
                .build();
    }
    public Stadium toStadiumInfo() {
        return Stadium.builder()
                .name(this.stadiumName)
                .address(this.stadiumAddress)
                .addressDetail(this.stadiumAddressDetail)
                .workStartTime(this.workStartTime)
                .workEndTime(this.workEndTime)
                .fieldType(this.fieldType)
                .indoorStatus(this.indoorStatus)
                .build();
    }

}
