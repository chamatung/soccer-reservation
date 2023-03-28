package com.playsoccer.domain.player.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayerPayInfo is a Querydsl query type for PlayerPayInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayerPayInfo extends EntityPathBase<PlayerPayInfo> {

    private static final long serialVersionUID = -1152297103L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayerPayInfo playerPayInfo = new QPlayerPayInfo("playerPayInfo");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath bankName = createString("bankName");

    public final StringPath cardNumber = createString("cardNumber");

    public final StringPath cardType = createString("cardType");

    public final QPlayer player;

    public QPlayerPayInfo(String variable) {
        this(PlayerPayInfo.class, forVariable(variable), INITS);
    }

    public QPlayerPayInfo(Path<? extends PlayerPayInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayerPayInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayerPayInfo(PathMetadata metadata, PathInits inits) {
        this(PlayerPayInfo.class, metadata, inits);
    }

    public QPlayerPayInfo(Class<? extends PlayerPayInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.player = inits.isInitialized("player") ? new QPlayer(forProperty("player"), inits.get("player")) : null;
    }

}

