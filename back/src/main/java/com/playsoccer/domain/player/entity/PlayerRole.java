package com.playsoccer.domain.player.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerRoleId;

    @JoinColumn(name = "id")
    @ManyToOne
    private Player player;

    @JoinColumn(name = "role")
    @ManyToOne
    private Role role;

    public static PlayerRole setPlayerAndRole(Player insertPlayer, Role role) {
        return PlayerRole.builder()
                .player(insertPlayer)
                .role(role).build();
    }
}
