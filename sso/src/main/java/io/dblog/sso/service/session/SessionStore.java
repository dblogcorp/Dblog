package io.dblog.sso.service.session;

import io.dblog.common.redis.inter.RedisManager;
import io.dblog.common.util.SeriailizeUtils;
import io.dblog.common.util.json.JSONutils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

/**
 * {@code SessionStore}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Service
public class SessionStore {

    @Autowired
    private RedisManager redisManager;

    public String set(String authId, Session session) {
        int expireSeconds;
        if (null != session.getRememberMe() && session.getRememberMe()) {
            expireSeconds = 3600;
        } else {
            expireSeconds = 31536000;
        }

        return redisManager.setex(authId, expireSeconds, JSONutils.toJson(session));
    }

    public Session get(String authId) {
        String json = redisManager.get(authId);

        if (StringUtils.isNotBlank(json)) {
            return JSONutils.fromJson(json, Session.class);
        }
        return null;
    }

    public Long refresh(String authId, Session session) {
        int expireSeconds;
        if (null != session.getRememberMe() && session.getRememberMe()) {
            expireSeconds = 3600;
        } else {
            expireSeconds = 31536000;
        }

        return expire(authId, expireSeconds);
    }

    public Long expire(String authId, int expire) {
        return redisManager.expire(authId, expire);
    }

    public Long del(String authId) {
        return redisManager.del(authId);
    }
}