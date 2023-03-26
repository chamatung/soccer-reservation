package com.playsoccer.domain.player.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPayInfo {

    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Player player;
    @Column(length = 20, nullable = true)
    private String accountNumber;
    @Column(length = 20, nullable = true)
    private String bankName;
    @Column(length = 110, nullable = true)
    private String cardType;
    @Column(length = 20, nullable = true)
    private String cardNumber;
}
