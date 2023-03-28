package com.playsoccer.domain.player.repository;

import com.playsoccer.domain.player.entity.PlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerInfoRepository extends JpaRepository<PlayerInfo, Long> {

}
