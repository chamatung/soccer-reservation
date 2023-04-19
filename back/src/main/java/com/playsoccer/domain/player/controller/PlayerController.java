package com.playsoccer.domain.player.controller;

import com.playsoccer.domain.common.dto.TokenDTO;
import com.playsoccer.domain.player.dto.LoginDTO;
import com.playsoccer.domain.player.dto.PlayerInfoDTO;
import com.playsoccer.domain.player.dto.RegistDTO;
import com.playsoccer.domain.player.entity.Player;
import com.playsoccer.domain.player.entity.PlayerInfo;
import com.playsoccer.domain.player.repository.PlayerRepository;
import com.playsoccer.domain.player.service.PlayerService;
import com.playsoccer.global.config.JwtFilter;
import com.playsoccer.global.config.TokenProvider;
import com.playsoccer.global.util.SecurityUtil;
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
    * 이 메소드는 RegistDTO 객체를 매개변수로 받아 Map<String,String> 타입의 데이터를 ResponseEntity로 반환합니다.
    *
    * @param reg 회원가입 데이터를 담고 있는 RegistDTO 객체
    * @return {ResponseEntity<Map<String, String>>} ResponseEntity로 매핑된 Map<String,String> 객체
    * */
    @PostMapping("/regist")
    public ResponseEntity<Map<String, String>> regist(@RequestBody(required = false)RegistDTO reg) {
        return playerService.regist(reg);
    }
    /**
    * 로그인 요청을 처리하고, JWT토큰을 생성하여 반환
    *
    * @param login 로그인 요청정보를 담고 있는 LoginDTO 객체
    * @return {@link com.playsoccer.domain.common.dto.TokenDTO} ResponseEntity로 매핑된 JWT토큰 정보를 담고 있는 TokenDTO 객체
    * */
    @PostMapping("/signIn")
    public ResponseEntity<TokenDTO> signIn(@RequestBody(required = false) LoginDTO login) {
        System.out.println(login.toString());
        // LoginDTO에서 이메일과 비밀번호 정보를 추출하여 인증(Authentication) 수행
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.email(), login.password());
        // AuthenticationManagerBuilder를 사용하여 Authentication 객체 생성
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // SecurityContextHolder를 사용하여 인증 정보를 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //JWT토큰 생성
        String jwt = tokenProvider.createToken(authentication);

        // JWT토큰 정보를 HttpHeaders에 추가
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        // TokenDTO 객체를 ResponseEntity로 래핑하여 반환
        return new ResponseEntity<>(new TokenDTO(jwt),httpHeaders, HttpStatus.OK);
    }

    /**
    * 회원정보를 요청하여 PlayerInfoDTO를 반환
    *
    * @return {@link com.playsoccer.domain.player.dto.PlayerInfoDTO} 회원정보를 담고 있는 PlayerInfoDTO 객체
    */
    @GetMapping("/my-info")
    public PlayerInfoDTO findInfo() {
        String username = SecurityUtil.getCurrentUsername().get();

        Player player = playerRepository.findByEmail(username);
        PlayerInfo playerInfo = player.getPlayerInfo();

        return PlayerInfoDTO.from(player, playerInfo);
    }
}
