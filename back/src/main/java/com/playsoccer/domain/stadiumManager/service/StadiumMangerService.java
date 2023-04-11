package com.playsoccer.domain.stadiumManager.service;

import com.playsoccer.domain.area.entity.Area;
import com.playsoccer.domain.area.repository.AreaRepository;
import com.playsoccer.domain.game.service.GameService;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.repository.PlayerRepository;
import com.playsoccer.domain.stadium.entity.Stadium;
import com.playsoccer.domain.stadium.repository.StadiumRepository;
import com.playsoccer.domain.stadiumManager.dto.StadiumManagerDTO;
import com.playsoccer.domain.stadiumManager.entity.StadiumManager;
import com.playsoccer.domain.stadiumManager.repository.StadiumMangerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StadiumMangerService {

    private final StadiumMangerRepository stadiumMangerRepository;
    private final StadiumRepository stadiumRepository;
    private final PlayerRepository playerRepository;
    private final AreaRepository areaRepository;
    private final GameService gameService;

    //responseEntity는 controller에서 map만 return
    public ResponseEntity<Map<String, String>> regist(StadiumManagerDTO regist) {
        Map<String, String> map = new HashMap<>();

        Player player = playerRepository.findByEmail(regist.getEmail());
        StadiumManager manager = stadiumMangerRepository.findByEmail(regist.getEmail());
        if(player != null || manager != null) {
            map.put("msg", "이미 등록된 회원입니다.");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        StadiumManager insertManager = regist.toStadiumManager();
        Stadium insertStadiumInfo = regist.toStadiumInfo();

        Optional<Area> area = areaRepository.findByName(insertStadiumInfo.getName());
        insertStadiumInfo.setArea(area);

        Stadium stadium = stadiumRepository.save(insertStadiumInfo);
        insertManager.setStadium(stadium);
        stadiumMangerRepository.save(insertManager);

        gameService.createGameStadiumOne(stadium); // 게임생성


        map.put("msg", "회원가입 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
