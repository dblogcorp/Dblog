package io.dblog.common.redis;

import io.dblog.common.redis.inter.RedisFactory;
import io.dblog.common.redis.inter.RedisManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RedisSetting.class)
public class RedisConfig {

    @Bean
    RedisManager redisManager(RedisSetting redisSetting) {
        return RedisFactory.redisManager(redisSetting);
    }
}