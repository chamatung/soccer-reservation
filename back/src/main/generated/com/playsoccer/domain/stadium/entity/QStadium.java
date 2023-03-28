package com.playsoccer.domain.stadium.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStadium is a Querydsl query type for Stadium
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStadium extends EntityPathBase<Stadium> {

    private static final long serialVersionUID = -2092504951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStadium stadium = new QStadium("stadium");

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final com.playsoccer.domain.area.entity.QArea area;

    public final NumberPath<Long> fieldId = createNumber("fieldId", Long.class);

    public final StringPath fieldType = createString("fieldType");

    public final StringPath indoorStatus = createString("indoorStatus");

    public final com.playsoccer.domain.stadiumManager.entity.QStadiumManager manager;

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> workEndTime = createDateTime("workEndTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> workStartTime = createDateTime("workStartTime", java.time.LocalDateTime.class);

    public QStadium(String variable) {
        this(Stadium.class, forVariable(variable), INITS);
    }

    public QStadium(Path<? extends Stadium> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStadium(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStadium(PathMetadata metadata, PathInits inits) {
        this(Stadium.class, metadata, inits);
    }

    public QStadium(Class<? extends Stadium> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new com.playsoccer.domain.area.entity.QArea(forProperty("area")) : null;
        this.manager = inits.isInitialized("manager") ? new com.playsoccer.domain.stadiumManager.entity.QStadiumManager(forProperty("manager"), inits.get("manager")) : null;
    }

}

