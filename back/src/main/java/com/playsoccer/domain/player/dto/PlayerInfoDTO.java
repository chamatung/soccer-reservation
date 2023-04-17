package com.playsoccer.domain.player.dto;

import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

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

    public static PlayerInfoDTO from(Player player, PlayerInfo playerInfo){
        return PlayerInfoDTO.builder()
                .name(player.getName())
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

    public static PlayerInfoDTO fromPlayer(Player player) {
        return PlayerInfoDTO.builder()
                .name(player.getName())
                .email(player.getEmail())
                .birth(player.getBirth()).build();
    }
}
