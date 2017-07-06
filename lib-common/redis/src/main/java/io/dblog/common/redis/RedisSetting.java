package io.dblog.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Redis Setting
 *
 *
 *
 */
@Data
@ConfigurationProperties(prefix = "cache.redis")
public class RedisSetting {

    private String redisHost;

    private Integer redisPort;

    private Integer timeOut;

    private String password;

    // Database Index, default 0
    private Integer redisDataBase = 0;

    private Integer redisMaxActive;

    private Integer maxIdle;

    private Integer maxWait;

    private Integer minIdle;
}
