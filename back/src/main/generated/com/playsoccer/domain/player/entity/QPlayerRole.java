package com.playsoccer.domain.player.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayerRole is a Querydsl query type for PlayerRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayerRole extends EntityPathBase<PlayerRole> {

    private static final long serialVersionUID = -947595173L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayerRole playerRole = new QPlayerRole("playerRole");

    public final QPlayer player;

    public final NumberPath<Long> playerRoleId = createNumber("playerRoleId", Long.class);

    public final QRole role;

    public QPlayerRole(String variable) {
        this(PlayerRole.class, forVariable(variable), INITS);
    }

    public QPlayerRole(Path<? extends PlayerRole> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayerRole(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayerRole(PathMetadata metadata, PathInits inits) {
        this(PlayerRole.class, metadata, inits);
    }

    public QPlayerRole(Class<? extends PlayerRole> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.player = inits.isInitialized("player") ? new QPlayer(forProperty("player"), inits.get("player")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

