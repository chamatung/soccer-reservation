package com.playsoccer.domain.stadiumManager.repository;


import com.playsoccer.domain.stadiumManager.entity.StadiumManager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumMangerRepository extends JpaRepository<StadiumManager, Long> {

    StadiumManager findByEmail(String email);
}
