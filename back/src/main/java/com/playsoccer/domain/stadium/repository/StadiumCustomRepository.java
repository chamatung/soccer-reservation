package com.playsoccer.domain.stadium.repository;

import com.playsoccer.domain.stadium.dto.StadiumDTO;

import java.util.List;

public interface StadiumCustomRepository {

    List<StadiumDTO> findStadiumList();
}
