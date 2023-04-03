package com.playsoccer.domain.stadium.repository;


import com.playsoccer.domain.stadium.dto.StadiumDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.playsoccer.domain.stadium.entity.QStadium.stadium;
import static com.playsoccer.domain.game.entity.QGame.game;


@RequiredArgsConstructor
public class StadiumCustomRepositoryImpl implements StadiumCustomRepository{

    private final JPAQueryFactory querydsl;

    @Override
    public List<StadiumDTO> findStadiumList() {
        List<StadiumDTO> list = querydsl.select(
                        Projections.constructor(
                                StadiumDTO.class,
                                stadium.fieldId,
                                stadium.workStartTime,
                                stadium.workEndTime
                        ))
                .from(stadium).fetch();
        return list;
    }
}
