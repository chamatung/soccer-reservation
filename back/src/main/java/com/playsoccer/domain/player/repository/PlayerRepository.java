package com.playsoccer.domain.player.repository;

import com.playsoccer.domain.player.dto.PlayerInfoDTO;
import com.playsoccer.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.DoubleStream;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByEmail(String email);
}
