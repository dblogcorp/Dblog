package io.dblog.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis Setting
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "cache.redis")
public class RedisSetting {

    private String host;

    private Integer port;

    private Integer timeOut;

    private String password;

    // Database Index, default 0
    private Integer database = 0;

    private Integer maxActive;

    private Integer maxIdle;

    private Integer maxWait;

    private Integer minIdle;

    private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
}
