package com.playsoccer.domain.pay.entity;

import com.playsoccer.domain.player.entity.Player;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payId;
    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Player player;
    @Column(length = 15, nullable = false)
    private String status;
    @Column(nullable = false)
    private Integer amount;
    @Column(length = 30, nullable = false)
    private String payType;
}
