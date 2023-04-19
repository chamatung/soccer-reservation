package com.playsoccer.domain.stadiummanager.repository;


import com.playsoccer.domain.stadiummanager.entity.StadiumManager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumMangerRepository extends JpaRepository<StadiumManager, Long> {

    StadiumManager findByEmail(String email);
}
