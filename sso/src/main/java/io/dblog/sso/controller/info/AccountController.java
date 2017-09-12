package io.dblog.sso.controller.info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pelin on 17/8/1.
 */
@RestController
public class AccountController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {

    }
}