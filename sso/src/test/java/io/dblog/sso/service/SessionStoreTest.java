package io.dblog.sso.service;

import io.dblog.common.redis.inter.RedisManager;
import io.dblog.sso.service.session.SessionStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * {@code SessionStoreTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class SessionStoreTest extends BaseServiceTest {

    @Autowired
    private SessionStore sessionStore;

    @Autowired
    private RedisManager redisManager;
}
