package com.playsoccer.domain.player.repository;

import com.playsoccer.domain.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByEmail(String email);

//    @Query("select p from Player p where id =:testId")
//    Player test(String testId)
}
