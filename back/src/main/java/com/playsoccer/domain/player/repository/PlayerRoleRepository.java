package com.playsoccer.domain.player.repository;

import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRoleRepository extends JpaRepository<PlayerRole, Player> {
}
