package com.playsoccer.domain.gamerecord.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameRecord is a Querydsl query type for GameRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameRecord extends EntityPathBase<GameRecord> {

    private static final long serialVersionUID = -100339543L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameRecord gameRecord = new QGameRecord("gameRecord");

    public final com.playsoccer.domain.game.entity.QGame game;

    public final com.playsoccer.domain.player.entity.QPlayer player;

    public final NumberPath<Integer> playScore = createNumber("playScore", Integer.class);

    public final com.playsoccer.domain.stadium.entity.QStadium stadium;

    public final NumberPath<Integer> warn = createNumber("warn", Integer.class);

    public QGameRecord(String variable) {
        this(GameRecord.class, forVariable(variable), INITS);
    }

    public QGameRecord(Path<? extends GameRecord> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameRecord(PathMetadata metadata, PathInits inits) {
        this(GameRecord.class, metadata, inits);
    }

    public QGameRecord(Class<? extends GameRecord> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new com.playsoccer.domain.game.entity.QGame(forProperty("game"), inits.get("game")) : null;
        this.player = inits.isInitialized("player") ? new com.playsoccer.domain.player.entity.QPlayer(forProperty("player"), inits.get("player")) : null;
        this.stadium = inits.isInitialized("stadium") ? new com.playsoccer.domain.stadium.entity.QStadium(forProperty("stadium"), inits.get("stadium")) : null;
    }

}

