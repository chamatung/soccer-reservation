package com.playsoccer.domain.pay.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayDetail is a Querydsl query type for PayDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayDetail extends EntityPathBase<PayDetail> {

    private static final long serialVersionUID = 519727706L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPayDetail payDetail = new QPayDetail("payDetail");

    public final DatePath<java.time.LocalDate> insertDate = createDate("insertDate", java.time.LocalDate.class);

    public final QPay pay;

    public final NumberPath<Long> payDetailId = createNumber("payDetailId", Long.class);

    public final StringPath status = createString("status");

    public QPayDetail(String variable) {
        this(PayDetail.class, forVariable(variable), INITS);
    }

    public QPayDetail(Path<? extends PayDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPayDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPayDetail(PathMetadata metadata, PathInits inits) {
        this(PayDetail.class, metadata, inits);
    }

    public QPayDetail(Class<? extends PayDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pay = inits.isInitialized("pay") ? new QPay(forProperty("pay"), inits.get("pay")) : null;
    }

}

