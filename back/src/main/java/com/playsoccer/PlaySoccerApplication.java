package com.playsoccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PlaySoccerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlaySoccerApplication.class, args);
    }

}
