package io.dblog.common.redis;

import io.dblog.common.redis.inter.RedisManager;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * {@code RedisManagerTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@FixMethodOrder(MethodSorters.JVM)
public class RedisManagerTest extends BaseRedisTest {

    @Autowired
    private RedisManager redisManager;

    private String test_key = "test_li";

    private String value = "Pelin_li";

    @Test
    public void testSet() {
        assertEquals("OK", redisManager.set(test_key, value));
    }

    @Test
    public void testGet() {
        assertEquals(value, redisManager.get("test_li"));
    }
}