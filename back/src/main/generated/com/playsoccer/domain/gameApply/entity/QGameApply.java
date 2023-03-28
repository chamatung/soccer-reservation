package com.playsoccer.domain.gameApply.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameApply is a Querydsl query type for GameApply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameApply extends EntityPathBase<GameApply> {

    private static final long serialVersionUID = 1582052841L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameApply gameApply = new QGameApply("gameApply");

    public final com.playsoccer.domain.game.entity.QGame game;

    public final NumberPath<Long> gameApplyId = createNumber("gameApplyId", Long.class);

    public final com.playsoccer.domain.player.entity.QPlayer player;

    public final com.playsoccer.domain.stadium.entity.QStadium stadium;

    public QGameApply(String variable) {
        this(GameApply.class, forVariable(variable), INITS);
    }

    public QGameApply(Path<? extends GameApply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameApply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameApply(PathMetadata metadata, PathInits inits) {
        this(GameApply.class, metadata, inits);
    }

    public QGameApply(Class<? extends GameApply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new com.playsoccer.domain.game.entity.QGame(forProperty("game"), inits.get("game")) : null;
        this.player = inits.isInitialized("player") ? new com.playsoccer.domain.player.entity.QPlayer(forProperty("player"), inits.get("player")) : null;
        this.stadium = inits.isInitialized("stadium") ? new com.playsoccer.domain.stadium.entity.QStadium(forProperty("stadium"), inits.get("stadium")) : null;
    }

}

