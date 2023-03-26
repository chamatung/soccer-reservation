package com.playsoccer.domain.player.repository;

import com.playsoccer.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByEmail(String email);
}
