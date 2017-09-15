package io.dblog.sso;

import io.dblog.common.db.DBConfig;
import io.dblog.common.email.EmailConfig;
import io.dblog.common.redis.RedisConfig;
import io.dblog.common.server.BaseConfig;
import io.dblog.common.server.BaseServer;
import io.dblog.sso.config.JpaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by Pelin on 17/8/1.
 */
@Import({
        BaseConfig.class,
        DBConfig.class,
        RedisConfig.class,
        EmailConfig.class,
        JpaConfig.class
})
@ComponentScan
@ServletComponentScan
@EnableAspectJAutoProxy
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        BaseServer.run(Application.class, args);
    }
}