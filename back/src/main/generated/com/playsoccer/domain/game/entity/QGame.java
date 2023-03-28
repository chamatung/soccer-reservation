package com.playsoccer.domain.game.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGame is a Querydsl query type for Game
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGame extends EntityPathBase<Game> {

    private static final long serialVersionUID = 1444698471L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGame game = new QGame("game");

    public final ListPath<com.playsoccer.domain.gameApply.entity.GameApply, com.playsoccer.domain.gameApply.entity.QGameApply> gameApplies = this.<com.playsoccer.domain.gameApply.entity.GameApply, com.playsoccer.domain.gameApply.entity.QGameApply>createList("gameApplies", com.playsoccer.domain.gameApply.entity.GameApply.class, com.playsoccer.domain.gameApply.entity.QGameApply.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> gameDate = createDate("gameDate", java.time.LocalDate.class);

    public final NumberPath<Long> gameId = createNumber("gameId", Long.class);

    public final ListPath<com.playsoccer.domain.gameRecord.entity.GameRecord, com.playsoccer.domain.gameRecord.entity.QGameRecord> gameRecords = this.<com.playsoccer.domain.gameRecord.entity.GameRecord, com.playsoccer.domain.gameRecord.entity.QGameRecord>createList("gameRecords", com.playsoccer.domain.gameRecord.entity.GameRecord.class, com.playsoccer.domain.gameRecord.entity.QGameRecord.class, PathInits.DIRECT2);

    public final com.playsoccer.domain.stadium.entity.QStadium stadium;

    public final DatePath<java.time.LocalDate> startTime = createDate("startTime", java.time.LocalDate.class);

    public final StringPath status = createString("status");

    public final NumberPath<Integer> totalMember = createNumber("totalMember", Integer.class);

    public QGame(String variable) {
        this(Game.class, forVariable(variable), INITS);
    }

    public QGame(Path<? extends Game> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGame(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGame(PathMetadata metadata, PathInits inits) {
        this(Game.class, metadata, inits);
    }

    public QGame(Class<? extends Game> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stadium = inits.isInitialized("stadium") ? new com.playsoccer.domain.stadium.entity.QStadium(forProperty("stadium"), inits.get("stadium")) : null;
    }

}

