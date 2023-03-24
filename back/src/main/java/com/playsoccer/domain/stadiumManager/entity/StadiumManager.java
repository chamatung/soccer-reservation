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
    @JoinColumn(name = "fieldId")
    private Stadium stadium;

    private String pw;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String addressDetail;
    private String managerLevel;

}
