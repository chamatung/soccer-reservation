package com.playsoccer.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import static jakarta.servlet.DispatcherType.REQUEST;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsFilter corsFilter;
    private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final AccessDeniedHandler jwtAccessDeniedHandler;
    private final TokenProvider tokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                //jwt 인증 방식이기 때문에 csrf를 disable합니다.
                .csrf().disable()
                //filter 우선적으로 corsfilter적용 후 usernamePasswordAuthenticationFilter적용
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                //인증, 인가 예외처리
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                /*
                * "무상태(stateless)"는 세션 관리 방식 중 하나로,
                * 서버가 클라이언트의 세션 상태를 저장하지 않는 것을 의미
                * 각각의 클라이언트 요청은 독립적으로 처리되며,
                * 이전 요청에 대한 상태나 정보를 서버가 유지하지 않움
                * */
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/s/player/regist", "/api/s/player/signIn").permitAll()
                .anyRequest().authenticated()
//                .authorizeHttpRequests(authorize -> authorize
//                        .dispatcherTypeMatchers(REQUEST).permitAll()
//                        .requestMatchers("/api/s/player/regist", "/api/s/player/signIn").permitAll()
//                        .anyRequest().authenticated())
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));

        return http.build();
    }
}
