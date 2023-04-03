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

    public final StringPath gameAvailability = createString("gameAvailability");

    public final StringPath gameDay = createString("gameDay");

    public final NumberPath<Long> gameId = createNumber("gameId", Long.class);

    public final StringPath gameMonth = createString("gameMonth");

    public final StringPath gameYear = createString("gameYear");

    public final com.playsoccer.domain.stadium.entity.QStadium stadium;

    public final NumberPath<Integer> startTime = createNumber("startTime", Integer.class);

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

