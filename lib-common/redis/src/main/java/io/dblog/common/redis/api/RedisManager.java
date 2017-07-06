package io.dblog.common.redis.api;

import redis.clients.jedis.JedisPool;

/**
 * Created by Pelin on 17/7/6.
 */
public interface RedisManager {

    JedisPool getPool();

    String get(String key);

    byte[] getBytes(String key);

    String set(String key, String value);

    String set(byte[] key, byte[] value);

    String setex(String key, int exp, String value);

    String setex(byte[] key, int exp, byte[] value);
}
