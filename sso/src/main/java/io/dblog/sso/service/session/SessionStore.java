package io.dblog.sso.service.session;

import io.dblog.common.redis.inter.RedisManager;
import io.dblog.common.util.json.JSONutils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String set(String sid, Session session) {
        int expireSeconds;
        if (null != session.getRememberMe() && session.getRememberMe()) {
            expireSeconds = 3600;
        } else {
            expireSeconds = 31536000;
        }

        return redisManager.setex(sid, expireSeconds, session.toString());
    }

    public Session get(String sid) {
        String json = redisManager.get(sid);

        if (StringUtils.isNotBlank(json)) {
            return JSONutils.fromJson(json, Session.class);
        }
        return null;
    }

    public Long refresh(String sid, Session session) {
        int expireSeconds;
        if (null != session.getRememberMe() && session.getRememberMe()) {
            expireSeconds = 3600;
        } else {
            expireSeconds = 31536000;
        }

        return expire(sid, expireSeconds);
    }

    public Long expire(String sid, int expire) {
        return redisManager.expire(sid, expire);
    }

    public Long del(String sid) {
        return redisManager.del(sid);
    }
}