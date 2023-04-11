package com.playsoccer.domain.player.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayerInfo is a Querydsl query type for PlayerInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayerInfo extends EntityPathBase<PlayerInfo> {

    private static final long serialVersionUID = -947864429L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayerInfo playerInfo = new QPlayerInfo("playerInfo");

    public final NumberPath<Integer> carrer = createNumber("carrer", Integer.class);

    public final StringPath height = createString("height");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath level = createString("level");

    public final StringPath nation = createString("nation");

    public final QPlayer player;

    public final StringPath playFoot = createString("playFoot");

    public final StringPath position = createString("position");

    public final StringPath weight = createString("weight");

    public QPlayerInfo(String variable) {
        this(PlayerInfo.class, forVariable(variable), INITS);
    }

    public QPlayerInfo(Path<? extends PlayerInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayerInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayerInfo(PathMetadata metadata, PathInits inits) {
        this(PlayerInfo.class, metadata, inits);
    }

    public QPlayerInfo(Class<? extends PlayerInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.player = inits.isInitialized("player") ? new QPlayer(forProperty("player"), inits.get("player")) : null;
    }

}

