package com.playsoccer.domain.gameApply.service;

import com.playsoccer.domain.game.entity.Game;
import com.playsoccer.domain.game.repository.GameRepository;
import com.playsoccer.domain.gameApply.dto.GameApplyDTO;
import com.playsoccer.domain.gameApply.entity.GameApply;
import com.playsoccer.domain.gameApply.repository.GameApplyRepository;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.repository.PlayerRepository;
import com.playsoccer.domain.stadium.entity.Stadium;
import com.playsoccer.domain.stadium.repository.StadiumRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GameApplyService {

    private final GameApplyRepository gameApplyRepository;
    private final PlayerRepository playerRepository;
    private final StadiumRepository stadiumRepository;
    private final GameRepository gameRepository;

    @Transactional
    public ResponseEntity<Map<String, String>> addGameApply(GameApplyDTO apply) {
        Map<String,String> map = new HashMap<>();

        Optional<Player> player = Optional.ofNullable(playerRepository.findByEmail(apply.getEmail()));
        Optional<Game> game = gameRepository.findById(apply.getGameId());
        Optional<Stadium> stadium = stadiumRepository.findById(apply.getFieldId());

        if(player.isPresent() && game.isPresent() && stadium.isPresent()) {
            GameApply insertGameApply = GameApply.builder()
                    .game(game.get())
                    .player(player.get())
                    .stadium(stadium.get())
                    .build();

            GameApply gameAppy = gameApplyRepository.save(insertGameApply);

            int cnt = gameApplyRepository.countByGame(game.get());
            if(cnt == 18) {
                game.get().changeStatus("마감");
            }

            map.put("msg", "신청 완료");
        } else {
            map.put("msg", "신청 실패");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, String>> deleteGameApply(GameApplyDTO cancel) {
        Map<String,String> map = new HashMap<>();

        Optional<Player> player = Optional.ofNullable(playerRepository.findByEmail(cancel.getEmail()));
        Optional<Game> game = gameRepository.findById(cancel.getGameId());

        if(player.isPresent() && game.isPresent()) {
            GameApply gameApply = gameApplyRepository.findByPlayerAndGame(player, game);
            gameApplyRepository.delete(gameApply);
            map.put("msg", "신청취소 완료");
        }else {
            map.put("msg", "신청취소 실패");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
