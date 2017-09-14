package io.dblog.sso.service;

import io.dblog.jpa.sso.entity.Account;
import io.dblog.sso.service.session.Session;
import io.dblog.sso.service.session.SessionStore;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * {@code SessionStoreTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class SessionStoreTest extends BaseServiceTest {

    @Autowired
    private SessionStore sessionStore;

    private String authId;

    private Session session;

    @Before
    public void init() {
        authId = "user:001";
        session = new Session();

        Account account = new Account();
        account.setName("Pelin_li");
        session.setAccount(account);
    }

    @Test
    public void testSet() {
        assertEquals("OK", sessionStore.set(authId, session));
    }

    @Test
    public void testGet() {
        Session tmp = sessionStore.get(authId);

        assertNotNull("SessionStore get() is failed, result is null!", tmp);
    }
}