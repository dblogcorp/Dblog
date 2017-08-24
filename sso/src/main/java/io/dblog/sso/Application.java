package io.dblog.sso;

import io.dblog.common.db.DBConfig;
import io.dblog.common.redis.RedisConfig;
import io.dblog.common.server.BaseConfig;
import io.dblog.common.server.BaseServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Pelin on 17/8/1.
 */
@Import({
        BaseConfig.class,
        DBConfig.class,
        RedisConfig.class
})
@ComponentScan
@Configuration
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        BaseServer.run(Application.class, args);
    }
}