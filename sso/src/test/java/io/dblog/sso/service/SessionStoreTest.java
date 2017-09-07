package io.dblog.sso.service;

import io.dblog.sso.service.session.SessionStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * {@code SessionStoreTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class SessionStoreTest extends BaseService {

    @Autowired
    private SessionStore sessionStore;

    @Test
    public void testSet() {
        System.out.println(sessionStore);
    }
}
