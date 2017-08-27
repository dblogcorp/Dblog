package io.dblog.jpa.sso.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrivateLetter is a Querydsl query type for PrivateLetter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrivateLetter extends EntityPathBase<PrivateLetter> {

    private static final long serialVersionUID = 188804736L;

    public static final QPrivateLetter privateLetter = new QPrivateLetter("privateLetter");

    public final io.dblog.jpa.sso.QBaseEntity _super = new io.dblog.jpa.sso.QBaseEntity(this);

    public final NumberPath<Integer> accountId = createNumber("accountId", Integer.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.sql.Timestamp> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final NumberPath<Integer> letterBy = createNumber("letterBy", Integer.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public QPrivateLetter(String variable) {
        super(PrivateLetter.class, forVariable(variable));
    }

    public QPrivateLetter(Path<? extends PrivateLetter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrivateLetter(PathMetadata metadata) {
        super(PrivateLetter.class, metadata);
    }

}

