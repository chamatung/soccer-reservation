package com.playsoccer.domain.stadium.entity;

import com.playsoccer.domain.area.entity.Area;
import com.playsoccer.domain.stadiumManager.entity.StadiumManager;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areaId", nullable = false)
    private Area area;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String address;
    @Column(length = 100, nullable = true)
    private String addressDetail;
    @Column(nullable = false)
    private LocalDateTime workStartTime;
    @Column(nullable = false)
    private LocalDateTime workEndTime;
    @Column(length = 15, nullable = false)
    private String fieldType;
    @Column(length = 3, nullable = false)
    private String indoorStatus;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stadium")
    private StadiumManager manager;
}
