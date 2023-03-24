package com.playsoccer.domain.stadium.entity;

import com.playsoccer.domain.area.entity.Area;
import com.playsoccer.domain.stadiumManager.entity.StadiumManager;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldId;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stadium")
    private StadiumManager manager;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areaId")
    private Area area;
    private String name;
    private String address;
    private String addressDetail;
    private LocalDate workDate;
    private String fieldType;
}
