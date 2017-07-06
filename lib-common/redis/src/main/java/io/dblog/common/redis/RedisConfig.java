package io.dblog.common.redis;

import io.dblog.common.redis.api.RedisFactory;
import io.dblog.common.redis.api.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = RedisConfig.class)
public class RedisConfig {

    @Autowired
    private RedisSetting redisSetting;

    @Bean
    RedisManager redisManager() {
        return RedisFactory.redisManager(redisSetting);
    }
}
