package com.playsoccer.domain.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JWT 토큰 정보를 담는 클래스입니다.
 *
 * @Description
 * 이 클래스는 JWT(JSON Web Token) 인증을 위해 생성된 토큰 정보를 담는 DTO(Data Transfer Object)입니다.
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    /**
     * 사용자 JWT인증 정보를 담는 변수
     *
     * @return {@link String} 타입의 JWT 토큰 정보
     * @see #token
     * */
    private String token;
}
