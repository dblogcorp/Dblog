package io.dblog.jpa.sso.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 1082586724L;

    public static final QAccount account = new QAccount("account");

    public final io.dblog.jpa.sso.QBaseEntity _super = new io.dblog.jpa.sso.QBaseEntity(this);

    public final StringPath codingAdd = createString("codingAdd");

    public final StringPath company = createString("company");

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.sql.Timestamp> deletedAt = _super.deletedAt;

    public final StringPath email = createString("email");

    public final BooleanPath emailValidation = createBoolean("emailValidation");

    public final StringPath githubAdd = createString("githubAdd");

    public final StringPath gravatar = createString("gravatar");

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final StringPath intro = createString("intro");

    public final StringPath location = createString("location");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath registerIp = createString("registerIp");

    public final NumberPath<Integer> role = createNumber("role", Integer.class);

    public final NumberPath<Short> sex = createNumber("sex", Short.class);

    public final StringPath sign = createString("sign");

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final StringPath twitterAdd = createString("twitterAdd");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public final StringPath userAgent = createString("userAgent");

    public final StringPath userName = createString("userName");

    public final StringPath website = createString("website");

    public final StringPath weiboAdd = createString("weiboAdd");

    public final StringPath zhihuAdd = createString("zhihuAdd");

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

