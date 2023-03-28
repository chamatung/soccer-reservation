package com.playsoccer.domain.player.dto;

import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class RegistDTO {

    private String email;
    private String password;
    private String name;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
    private String addressDetail;
    private Integer sportExperience;
    private String preferredPosition;
    private String preferredRegion;
    private String foot;
    private String weight;
    private String height;
    private String nationality;

    public Player toPlayer(RegistDTO regist) {
        return new Player().builder()
                .email(regist.getEmail())
                .password(regist.getPassword())
                .name(regist.getName())
                .birth(regist.getBirthDate())
                .phone(regist.phoneNumber)
                .address(regist.address)
                .addressDetail(regist.addressDetail != null ? regist.addressDetail : "")
                .build();
    }
    public PlayerInfo toPlayerInfo(RegistDTO regist) {
        return new PlayerInfo().builder()
                .carrer(regist.getSportExperience())
                .position(regist.getPreferredPosition())
                .playFoot(regist.getFoot())
                .height(regist.getHeight())
                .weight(regist.getWeight())
                .nation(regist.getNationality())
                .build();
    }
}
