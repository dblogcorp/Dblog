package io.dblog.sso.service.sign;

import io.dblog.common.exception.BadRequestException;
import io.dblog.jpa.sso.entity.Account;
import io.dblog.sso.controller.sign.LoginForm;
import io.dblog.sso.service.account.AccountService;
import io.dblog.sso.service.session.Session;
import io.dblog.sso.service.session.SessionStore;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pelin on 17/8/1.
 */
@Service
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private SessionStore sessionStore;

    public void login(HttpServletRequest request, LoginForm form) {

    }

    public void updateLoginSession(String userName, String authId) {
        Account account = accountService.findByUserName(userName);
        if (null == account) {
            logger.error("Login Error: user not exists, userName=" + userName);
            throw new BadRequestException("login.account.is.not.existed");
        }

        updateLoginSession(account, authId, false);
    }

    public void updateLoginSession(Account account, String authId) {
        if (null == account) {
            logger.error("Login Error: user not exists");
            throw new BadRequestException("login.account.is.not.existed");
        }

        updateLoginSession(account, authId, false);
    }

    public void updateLoginSession(Account account, String authId, Boolean rememberMe) {
        if (StringUtils.isBlank(authId)) {
            logger.error("Session update failed!");
            throw new BadRequestException("login.session.update.failed");
        }

        Session session = new Session();
        session.setAccount(account);
        session.setRememberMe(rememberMe);

        sessionStore.set(authId, session);
    }

}
