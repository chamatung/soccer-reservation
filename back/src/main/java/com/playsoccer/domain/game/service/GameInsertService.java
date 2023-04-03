package com.playsoccer.domain.game.service;

import com.playsoccer.domain.game.dto.GameDTO;
import com.playsoccer.domain.game.repository.GameRepository;
import com.playsoccer.domain.stadium.dto.StadiumDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GameInsertService {

    private final GameRepository gameRepository;

    @Transactional
    public void stadiumListGameInsert(String year, String month,int day, StadiumDTO stadium) {
        int[] time = {0,2,4,6,8,10,12,14,16,18,20,22,24};
        List<GameDTO> gameList = new ArrayList<>();

        LocalDate days = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month),1);
        int dayLength = days.lengthOfMonth();

        int start = Arrays.asList(time).indexOf(stadium.getWorkStartTime());
        int end = Arrays.asList(time).lastIndexOf(stadium.getWorkEndTime());

        //insert list 작성
        for(int i = day; i<= dayLength;i++) {
            for(int j = start; j<= end; j++) {
                GameDTO game = GameDTO.builder()
                        .fieldId(stadium.getFieldId())
                        .totalMember(18)
                        .gameDay(String.valueOf(i))
                        .startTime(time[j])
                        .status("모집중")
                        .gameYear(year)
                        .gameMonth(month)
                        .gameAvailability("가능")
                        .build();

                gameList.add(game);
            }
        }
        gameRepository.insertGameList(gameList);
    }
}
