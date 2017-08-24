package io.dblog.common.redis;

import io.dblog.common.redis.inter.RedisFactory;
import io.dblog.common.redis.inter.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan
@Configuration
public class RedisConfig {

    @Autowired
    private RedisSetting redisSetting;

    @Bean
    RedisManager redisManager() {
        return RedisFactory.redisManager(redisSetting);
    }
}