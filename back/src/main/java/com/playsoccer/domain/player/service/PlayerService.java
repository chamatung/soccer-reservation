package com.playsoccer.domain.player.service;

import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import com.playsoccer.domain.player.repository.PlayerInfoRepository;
import com.playsoccer.domain.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerInfoRepository playerInfoRepository;

    public ResponseEntity<Map<String, String>> signIn(LoginDTO login) {

        Map<String, String> map = new HashMap<>();

        if(login == null) {
            map.put("msg", "로그인 정보가 없습니다.");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        //orElseThrow 쓸 것
        Optional<Player> player = Optional.ofNullable(playerRepository.findByEmail(login.getEmail()));
        if(player.isPresent()) {
            if(StringUtils.equals(player.get().getEmail(),login.getEmail())) {
                if(StringUtils.equals(player.get().getPassword(),login.getEmail())) {
                    map.put("email", player.get().getEmail());
                    map.put("name", player.get().getName());
                    map.put("msg","로그인 성공");
                    return new ResponseEntity<>(map, HttpStatus.OK);
                }
            }
        }

        map.put("msg", "email/password를 다시 확인해주세요.");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Map<String, String>> regist(RegistDTO regist) {
        Map<String, String> map = new HashMap<>();

        if(regist == null) {
            map.put("msg", "회원가입 정보가 없습니다.");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        Player player = playerRepository.findByEmail(regist.getEmail());
        if(player != null) {
            map.put("msg", "이미 등록된 회원입니다.");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        Player insertPlayer = regist.toPlayer();
        playerRepository.save(insertPlayer);

        PlayerInfo insertInfo = regist.toPlayerInfo();
        insertInfo.changeId(insertPlayer.getId());
        playerInfoRepository.save(insertInfo);


        map.put("msg", "회원가입 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
