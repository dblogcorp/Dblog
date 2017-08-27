package io.dblog.jpa.sso.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotification is a Querydsl query type for Notification
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNotification extends EntityPathBase<Notification> {

    private static final long serialVersionUID = 2112169748L;

    public static final QNotification notification = new QNotification("notification");

    public final io.dblog.jpa.sso.QBaseEntity _super = new io.dblog.jpa.sso.QBaseEntity(this);

    public final NumberPath<Integer> accountId = createNumber("accountId", Integer.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.sql.Timestamp> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final NumberPath<Integer> notificationAccountId = createNumber("notificationAccountId", Integer.class);

    public final StringPath originalAddress = createString("originalAddress");

    public final StringPath originalTopic = createString("originalTopic");

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final NumberPath<Short> type = createNumber("type", Short.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public QNotification(String variable) {
        super(Notification.class, forVariable(variable));
    }

    public QNotification(Path<? extends Notification> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotification(PathMetadata metadata) {
        super(Notification.class, metadata);
    }

}

