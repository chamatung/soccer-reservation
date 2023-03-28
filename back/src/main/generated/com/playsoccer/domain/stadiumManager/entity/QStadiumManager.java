package com.playsoccer.domain.stadiumManager.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStadiumManager is a Querydsl query type for StadiumManager
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStadiumManager extends EntityPathBase<StadiumManager> {

    private static final long serialVersionUID = 489648931L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStadiumManager stadiumManager = new QStadiumManager("stadiumManager");

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final StringPath email = createString("email");

    public final NumberPath<Long> managerId = createNumber("managerId", Long.class);

    public final StringPath managerLevel = createString("managerLevel");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath pw = createString("pw");

    public final com.playsoccer.domain.stadium.entity.QStadium stadium;

    public QStadiumManager(String variable) {
        this(StadiumManager.class, forVariable(variable), INITS);
    }

    public QStadiumManager(Path<? extends StadiumManager> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStadiumManager(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStadiumManager(PathMetadata metadata, PathInits inits) {
        this(StadiumManager.class, metadata, inits);
    }

    public QStadiumManager(Class<? extends StadiumManager> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stadium = inits.isInitialized("stadium") ? new com.playsoccer.domain.stadium.entity.QStadium(forProperty("stadium"), inits.get("stadium")) : null;
    }

}

