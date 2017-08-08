package io.dblog.common.redis.impl;

import io.dblog.common.redis.RedisSetting;
import io.dblog.common.redis.inter.RedisManager;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Pelin on 17/7/6.
 */
public class RedisManagerImpl implements RedisManager {

    private JedisPool pool;

    public RedisManagerImpl(RedisSetting setting) {
        pool = new JedisPool(
                setting.getJedisPoolConfig(),
                setting.getRedisHost(),
                setting.getRedisPort(),
                setting.getTimeOut(),
                setting.getPassword(),
                setting.getRedisDataBase()
        );
    }

    @Override
    public String get(String key) {
        try (Jedis client = pool.getResource()) {
            return client.get(key);
        }
    }

    @Override
    public JedisPool getPool() {
        return pool;
    }

    @Override
    public byte[] getBytes(String key) {
        try (BinaryJedis client = pool.getResource()) {
            return client.get(key.getBytes());
        }
    }

    @Override
    public String set(String key, String value) {
        try (Jedis client = pool.getResource()) {
            return client.set(key, value);
        }
    }

    @Override
    public String set(byte[] key, byte[] value) {
        try (BinaryJedis client = pool.getResource()) {
            return client.set(key, value);
        }
    }

    @Override
    public String setex(String key, int exp, String value) {
        try (Jedis client = pool.getResource()) {
            return client.setex(key, exp, value);
        }
    }

    @Override
    public String setex(byte[] key, int exp, byte[] value) {
        try (BinaryJedis client = pool.getResource()) {
            return client.setex(key, exp, value);
        }
    }
}
