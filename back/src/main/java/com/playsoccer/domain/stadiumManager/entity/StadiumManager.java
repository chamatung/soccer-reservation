package com.playsoccer.domain.stadiumManager.entity;

import com.playsoccer.domain.stadium.entity.Stadium;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StadiumManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fieldId", nullable = false)
    private Stadium stadium;
    @Column(length = 255, nullable = false)
    private String pw;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 11, nullable = false)
    private String phone;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String address;
    @Column(length = 100, nullable = true)
    private String addressDetail;
    @Column(length = 5, nullable = false)
    private String managerLevel; //주 , 부

}
