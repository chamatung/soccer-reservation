package com.playsoccer.domain.player.controller;

import com.playsoccer.domain.common.dto.TokenDTO;
import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.PlayerInfoDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.repository.PlayerRepository;
import com.playsoccer.domain.player.service.PlayerService;
import com.playsoccer.global.config.JwtFilter;
import com.playsoccer.global.config.TokenProvider;
import com.playsoccer.global.util.SecurityUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s/player")
public class PlayerController {
    private final PlayerService playerService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final PlayerRepository playerRepository;

    /**
    * 회원가입
    * @param {String} email
    * @param {String} password
    * @param {String} name
    * @param {LocalDate} birthDate
    * @param {String} phoneNumber
    * @param {String} address
    * @param {String} addressDetail
    * @param {String} sportExperience
    * @param {String} preferredPosition
    * @param {String} preferredRegion
    * @param {String} foot
    * @param {int} weight
    * @param {int} height
    * @param {String} nationality
    * @return
    * */
    @PostMapping("/regist")
    public ResponseEntity<Map<String, String>> regist(@RequestBody(required = false)RegistDTO regist) {
        return playerService.regist(regist);
    }
    /**
    * 로그인
    * @param {String} email
    * @param {String} password
    * @return
    * */
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(@RequestBody(required = false) LoginDTO login, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDTO(jwt),httpHeaders, HttpStatus.OK);
    }

    /**
    * 회원정보 ( 필요시 fromPlayer에 추가 )
    * @return {String} name
    * @return {String} email
    */
    @GetMapping("/my-info")
    public PlayerInfoDTO findInfo() {
        String username = SecurityUtil.getCurrentUsername().get();

        Player player = playerRepository.findByEmail(username);

        return PlayerInfoDTO.fromPlayer(player);
    }
}
