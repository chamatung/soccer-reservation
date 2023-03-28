package com.playsoccer.domain.stadium.repository;

import java.util.List;

public interface StadiumCustomRepository {
    List<Long> findStadiumNotGame();
}
