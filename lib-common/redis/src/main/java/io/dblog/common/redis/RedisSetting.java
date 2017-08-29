package io.dblog.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis Setting
 *
 */
@ConfigurationProperties(prefix = "cache.redis")
@Data
public class RedisSetting {

    private String host;

    private Integer port;

    private Integer timeout;

    private String password;

    // Database Index, default 0
    private Integer database = 0;

    private Integer maxActive;

    private Integer maxIdle;

    private Integer maxWait;

    private Integer minIdle;

    private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
}
