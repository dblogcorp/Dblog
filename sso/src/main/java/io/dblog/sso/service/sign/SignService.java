package io.dblog.sso.service.sign;

import io.dblog.sso.service.session.SessionStore;
import io.dblog.sso.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * {@code SignService}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Service
public class SignService {

    @Autowired
    private SessionStore sessionStore;

    public void signOut(HttpServletRequest request) {
        String authId = CookieUtils.getAuthId(request);
        if (StringUtils.isBlank(authId)) {
            return;
        }

        sessionStore.del(authId);
    }
}