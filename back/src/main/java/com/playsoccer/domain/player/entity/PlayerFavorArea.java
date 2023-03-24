package com.playsoccer.domain.player.entity;

import com.playsoccer.domain.area.entity.Area;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerFavorArea {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Player player; //선수
    private String name;

    @ManyToOne
    @JoinColumn(name = "areaId")
    private Area area;

}
