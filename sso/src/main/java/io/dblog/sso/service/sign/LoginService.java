package io.dblog.sso.service.sign;

import io.dblog.sso.controller.sign.LoginForm;
import io.dblog.sso.controller.sign.RegisterForm;
import io.dblog.sso.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pelin on 17/8/1.
 */
@Service
public class LoginService {


    @Autowired
    private AccountService accountService;

    public void login(HttpServletRequest request, LoginForm form) {

    }

}
