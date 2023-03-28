package com.playsoccer.domain.stadium.repository;

import com.playsoccer.domain.stadium.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long>, StadiumCustomRepository {
}
