package com.playsoccer.domain.stadium.repository;


import com.playsoccer.domain.stadium.dto.StadiumDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.playsoccer.domain.stadium.entity.QStadium.stadium;


@RequiredArgsConstructor
public class StadiumCustomRepositoryImpl implements StadiumCustomRepository{

    private final JPAQueryFactory querydsl;


    @Override
    public List<Long> findStadiumNotGame() {
//        return querydsl.select(Projections.constructor(
//                StadiumDTO.class
//        )).from(stadium).where(
//
//        );
        return null;
    }
}
