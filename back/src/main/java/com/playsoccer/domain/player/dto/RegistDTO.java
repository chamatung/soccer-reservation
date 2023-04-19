package com.playsoccer.domain.player.dto;

import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class RegistDTO {

    private String email;// 이메일
    private String password;// 비밀번호
    private String name;// 이름
    private LocalDate birthDate;// 생일
    private String phoneNumber;// 연락처
    private String address;// 주소
    private String addressDetail;// 상세주소
    private Integer sportExperience;// 경력
    private String preferredPosition;// 선호포지션
    private String preferredRegion;// 선호지역
    private String foot;// 발잡이 예) 왼발잡이 / 오른발잡이
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

    public void changePassword(String password) {
        this.password = password;
    }
}
