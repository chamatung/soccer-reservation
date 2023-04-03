package com.playsoccer.domain.area.repository;


import com.playsoccer.domain.area.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByName(String name);
}
