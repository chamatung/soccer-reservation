package com.playsoccer.domain.pay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PayDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payDetailId;
    @ManyToOne
    @JoinColumn(name = "payId", nullable = false)
    private Pay pay;
    @Column(length = 15, nullable = false)
    private String status;
    @Column(nullable = false)
    private LocalDate insertDate;
}
