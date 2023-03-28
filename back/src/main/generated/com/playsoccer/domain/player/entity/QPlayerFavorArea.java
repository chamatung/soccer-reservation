package com.playsoccer.domain.player.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayerFavorArea is a Querydsl query type for PlayerFavorArea
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayerFavorArea extends EntityPathBase<PlayerFavorArea> {

    private static final long serialVersionUID = 66716454L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayerFavorArea playerFavorArea = new QPlayerFavorArea("playerFavorArea");

    public final com.playsoccer.domain.area.entity.QArea area;

    public final StringPath name = createString("name");

    public final QPlayer player;

    public QPlayerFavorArea(String variable) {
        this(PlayerFavorArea.class, forVariable(variable), INITS);
    }

    public QPlayerFavorArea(Path<? extends PlayerFavorArea> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayerFavorArea(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayerFavorArea(PathMetadata metadata, PathInits inits) {
        this(PlayerFavorArea.class, metadata, inits);
    }

    public QPlayerFavorArea(Class<? extends PlayerFavorArea> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new com.playsoccer.domain.area.entity.QArea(forProperty("area")) : null;
        this.player = inits.isInitialized("player") ? new QPlayer(forProperty("player"), inits.get("player")) : null;
    }

}

