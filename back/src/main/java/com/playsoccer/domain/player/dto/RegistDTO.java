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

    public Player toPlayer() {
        return Player.builder()
                .email(this.getEmail())
                .password(this.getPassword())
                .name(this.getName())
                .birth(this.getBirthDate())
                .phone(this.phoneNumber)
                .address(this.address)
                .addressDetail(this.addressDetail != null ? this.addressDetail : "")
                .build();
    }
    public PlayerInfo toPlayerInfo() {
        return PlayerInfo.builder()
                .carrer(this.getSportExperience())
                .position(this.getPreferredPosition())
                .playFoot(this.getFoot())
                .height(this.getHeight())
                .weight(this.getWeight())
                .nation(this.getNationality())
                .build();
    }
}
