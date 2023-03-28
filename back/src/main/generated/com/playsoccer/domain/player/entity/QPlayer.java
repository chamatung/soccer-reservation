package com.playsoccer.domain.player.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayer is a Querydsl query type for Player
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayer extends EntityPathBase<Player> {

    private static final long serialVersionUID = 1988660805L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayer player = new QPlayer("player");

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final ListPath<com.playsoccer.domain.gameApply.entity.GameApply, com.playsoccer.domain.gameApply.entity.QGameApply> gameApplies = this.<com.playsoccer.domain.gameApply.entity.GameApply, com.playsoccer.domain.gameApply.entity.QGameApply>createList("gameApplies", com.playsoccer.domain.gameApply.entity.GameApply.class, com.playsoccer.domain.gameApply.entity.QGameApply.class, PathInits.DIRECT2);

    public final ListPath<com.playsoccer.domain.gameRecord.entity.GameRecord, com.playsoccer.domain.gameRecord.entity.QGameRecord> gameRecords = this.<com.playsoccer.domain.gameRecord.entity.GameRecord, com.playsoccer.domain.gameRecord.entity.QGameRecord>createList("gameRecords", com.playsoccer.domain.gameRecord.entity.GameRecord.class, com.playsoccer.domain.gameRecord.entity.QGameRecord.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final ListPath<PlayerFavorArea, QPlayerFavorArea> playerFavorAreaList = this.<PlayerFavorArea, QPlayerFavorArea>createList("playerFavorAreaList", PlayerFavorArea.class, QPlayerFavorArea.class, PathInits.DIRECT2);

    public final QPlayerInfo playerInfo;

    public QPlayer(String variable) {
        this(Player.class, forVariable(variable), INITS);
    }

    public QPlayer(Path<? extends Player> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayer(PathMetadata metadata, PathInits inits) {
        this(Player.class, metadata, inits);
    }

    public QPlayer(Class<? extends Player> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.playerInfo = inits.isInitialized("playerInfo") ? new QPlayerInfo(forProperty("playerInfo"), inits.get("playerInfo")) : null;
    }

}

