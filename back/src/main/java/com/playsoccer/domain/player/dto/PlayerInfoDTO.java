package com.playsoccer.domain.player.dto;

import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * 회원정보와 선수정보를 담는 클래스입니다.
 *
 * @Description
 * 이 클래스는 회원정보를 제공하기 위한 DTO(Data Transfer Object)입니다.
 * */
@Builder
@Data
public class PlayerInfoDTO {
    private String name;
    private LocalDate birth;
    private String email;
    //상세정보
    private String level;
    private int carrer;
    private String position;
    private String playFoot;
    private String weight;
    private String height;
    private String nation;

    /**
     * Player와 PlayerInfo 객체를 활용하여 PlayerInfoDTO 객체를 생성합니다.
     *
     * @param {@link Player} player 객체
     * @param {@link PlayerInfo} playerInfo 객체
     * @return {@link PlayerInfoDTO} PlayerInfoDTO 객체
     * */
    public static PlayerInfoDTO from(Player player, PlayerInfo playerInfo){
        return PlayerInfoDTO.builder()
                .name(player.getName())
                .email(player.getEmail())
                .birth(player.getBirth())
                .level(playerInfo.getLevel())
                .carrer(playerInfo.getCarrer())
                .position(playerInfo.getPosition())
                .playFoot(playerInfo.getPlayFoot())
                .weight(playerInfo.getWeight())
                .height(playerInfo.getHeight())
                .nation(playerInfo.getNation())
                .build();
    }

//    public static PlayerInfoDTO fromPlayer(Player player) {
//        return PlayerInfoDTO.builder()
//                .name(player.getName())
//                .email(player.getEmail())
//                .birth(player.getBirth()).build();
//    }
}
