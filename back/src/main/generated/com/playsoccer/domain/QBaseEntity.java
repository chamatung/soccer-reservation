package com.playsoccer.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = -228307750L;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final DatePath<java.time.LocalDate> createAt = createDate("createAt", java.time.LocalDate.class);

    public final StringPath createBy = createString("createBy");

    public final StringPath LastModifiedBy = createString("LastModifiedBy");

    public final DatePath<java.time.LocalDate> lastModifyAt = createDate("lastModifyAt", java.time.LocalDate.class);

    public QBaseEntity(String variable) {
        super(BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity(PathMetadata metadata) {
        super(BaseEntity.class, metadata);
    }

}

