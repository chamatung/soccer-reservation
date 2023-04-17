package com.playsoccer.domain.common.entity;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseEntity {

    //@CreatedBy
    private String createBy;
    //@LastModifiedBy
    private String LastModifiedBy;
    @CreatedDate
    private LocalDate createAt;
    @CreatedDate
    private LocalDate lastModifyAt;

}
