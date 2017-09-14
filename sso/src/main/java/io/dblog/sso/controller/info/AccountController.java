package io.dblog.sso.controller.info;

import io.dblog.sso.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pelin on 17/8/1.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        accountService.test();
    }
}