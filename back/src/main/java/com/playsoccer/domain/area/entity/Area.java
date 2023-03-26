package com.playsoccer.domain.area.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 15, nullable = false)
    private String code;
}
