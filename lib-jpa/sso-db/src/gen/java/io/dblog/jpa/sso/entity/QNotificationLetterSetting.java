package io.dblog.jpa.sso.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotificationLetterSetting is a Querydsl query type for NotificationLetterSetting
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNotificationLetterSetting extends EntityPathBase<NotificationLetterSetting> {

    private static final long serialVersionUID = 151508118L;

    public static final QNotificationLetterSetting notificationLetterSetting = new QNotificationLetterSetting("notificationLetterSetting");

    public final io.dblog.jpa.sso.QBaseEntity _super = new io.dblog.jpa.sso.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.sql.Timestamp> deletedAt = _super.deletedAt;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final NumberPath<Short> letterEmail = createNumber("letterEmail", Short.class);

    public final NumberPath<Short> letterPassed = createNumber("letterPassed", Short.class);

    public final NumberPath<Short> notificationFocus = createNumber("notificationFocus", Short.class);

    public final NumberPath<Short> notificationThumb = createNumber("notificationThumb", Short.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public QNotificationLetterSetting(String variable) {
        super(NotificationLetterSetting.class, forVariable(variable));
    }

    public QNotificationLetterSetting(Path<? extends NotificationLetterSetting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotificationLetterSetting(PathMetadata metadata) {
        super(NotificationLetterSetting.class, metadata);
    }

}

