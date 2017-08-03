package io.dblog.sso.service.sign;

import io.dblog.sso.controller.sign.RegisterForm;
import io.dblog.sso.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pelin on 17/8/1.
 */
public class RegisterService {

    @Autowired
    private AccountService accountService;

    public void register(HttpServletRequest request, RegisterForm form) {

    }
}
