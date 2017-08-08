package io.dblog.common.redis.inter;

import io.dblog.common.redis.RedisSetting;
import io.dblog.common.redis.impl.RedisManagerImpl;

/**
 * Created by Pelin on 17/7/6.
 */
public class RedisFactory {

    public static RedisManager redisManager(RedisSetting setting) {
        return new RedisManagerImpl(setting);
    }
}
