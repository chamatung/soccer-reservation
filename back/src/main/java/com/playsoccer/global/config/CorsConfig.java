package com.playsoccer.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    public CorsConfig() {
    }

    @Bean
    public org.springframework.web.filter.CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // Pattern을 빼고 작성하는 경우 equal과 같이 동일한 사이트만 접근 가능하고 패턴은 을 포함한 사이트는 모두 접근 가능
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        // 서버 경로로 접근하는 경우 CORS 설정 적용
        source.registerCorsConfiguration("/api/s/**", config);
        return new CorsFilter(source);
    }
}
