package com.playsoccer.domain.player.service;

import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    public ResponseEntity<MultiValueMap<String, String>> signIn(LoginDTO login) {

        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();

        if(login == null) {
            header.add("msg", "로그인 정보가 없습니다.");
            return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
        }
        //orElseThrow 쓸 것
        Player player = Optional.of(playerRepository.findByEmail(login.getEmail())).orElseThrow();

        if(player.getEmail().equals(login.getEmail())) {
            if(player.getPassword().equals(login.getEmail())) {
                header.add("msg","로그인 성공");
                return new ResponseEntity<>(header, HttpStatus.OK);
            }
        }

        header.add("msg", "email/password를 다시 확인해주세요.");
        return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<MultiValueMap<String, String>> regist(RegistDTO regist) {
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();

        if(regist == null) {
            header.add("msg", "회원가입 정보가 없습니다.");
            return new ResponseEntity<>(header, HttpStatus.NOT_FOUND);
        }
        Player player = playerRepository.findByEmail(regist.getEmail());
        if(player != null) {
            header.add("msg", "이미 등록된 회원입니다.");
            return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
        }
        header.add("msg", "회원가입 성공");
        return new ResponseEntity<>(header, HttpStatus.OK);
    }
}
