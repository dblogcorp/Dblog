package io.dblog.sso.util;

import io.dblog.common.util.EncryptUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * {@code CookieUtils}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class CookieUtils {

    public static String SESSION_NAME = "g_auth_id";

    public static Cookie getByName(HttpServletRequest request, String name) {
        if (null == request) {
            return null;
        }

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (null == cookie) {
                continue;
            }

            String cookieName = cookie.getName();
            if (Objects.equals(cookieName, name) && StringUtils.isNotBlank(cookie.getValue())) {
                return cookie;
            }
        }

        return null;
    }

    public static String getAuthId(HttpServletRequest request) {
        Cookie cookie = getByName(request, SESSION_NAME);
        if (null == cookie) {
            return null;
        }

        return cookie.getValue();
    }

    public static String generateAuthId() throws NoSuchAlgorithmException {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");

        return EncryptUtils.SHA1(uuid);
    }
}
