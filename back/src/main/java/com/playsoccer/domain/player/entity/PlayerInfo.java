package com.playsoccer.domain.player.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_player_info")
public class PlayerInfo {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Player player; //선수
    private String LEVEL;
    private int carrer;
    private String position;
    private String playFoot;
    private String weight;
    private String height;
    private String nation;



}
