package com.playsoccer.domain.player.service;

import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.PlayerInfoDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import com.playsoccer.domain.player.entity.PlayerRole;
import com.playsoccer.domain.player.entity.Role;
import com.playsoccer.domain.player.repository.PlayerInfoRepository;
import com.playsoccer.domain.player.repository.PlayerRepository;
import com.playsoccer.domain.player.repository.PlayerRoleRepository;
import com.playsoccer.domain.player.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.*;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerInfoRepository playerInfoRepository;
    private final RoleRepository roleRepository;
    private final PlayerRoleRepository playerRoleRepository;

    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<Map<String, String>> regist(RegistDTO regist) {
        Map<String, String> map = new HashMap<>();

        if(regist == null) {
            map.put("msg", "회원가입 정보가 없습니다.");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        regist.changePassword(passwordEncoder.encode(regist.getPassword()));

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

        Role role = new Role("ROLE_USER");
        PlayerRole playerRole = PlayerRole.setPlayerAndRole(insertPlayer, role);
        playerRoleRepository.save(playerRole);

        map.put("msg", "회원가입 성공");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public PlayerInfoDTO findInfo(String email) {
        Map<String, String> map = new HashMap<>();

        Player player = playerRepository.findByEmail(email);
        PlayerInfo playerInfo = player.getPlayerInfo();

        return PlayerInfoDTO.from(player,playerInfo);
    }
}
