package io.dblog.jpa.sso.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountRelationship is a Querydsl query type for AccountRelationship
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountRelationship extends EntityPathBase<AccountRelationship> {

    private static final long serialVersionUID = -1255912772L;

    public static final QAccountRelationship accountRelationship = new QAccountRelationship("accountRelationship");

    public final io.dblog.jpa.sso.QBaseEntity _super = new io.dblog.jpa.sso.QBaseEntity(this);

    public final NumberPath<Integer> accountId = createNumber("accountId", Integer.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.sql.Timestamp> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final NumberPath<Integer> relationAccountId = createNumber("relationAccountId", Integer.class);

    public final NumberPath<Short> type = createNumber("type", Short.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public QAccountRelationship(String variable) {
        super(AccountRelationship.class, forVariable(variable));
    }

    public QAccountRelationship(Path<? extends AccountRelationship> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountRelationship(PathMetadata metadata) {
        super(AccountRelationship.class, metadata);
    }

}

