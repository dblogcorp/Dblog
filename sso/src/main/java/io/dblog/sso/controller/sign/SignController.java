package io.dblog.sso.controller.sign;

import io.dblog.sso.service.sign.RegisterService;
import io.dblog.sso.service.sign.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Pelin on 17/8/1.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class SignController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private SignService signService;

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public void register(@Valid RegisterForm form, HttpServletRequest request,
                      @RequestHeader(value = "User-Agent") String userAgent,
                      @RequestAttribute String realRemoteAddress) throws NoSuchAlgorithmException {
        registerService.register(request, form, userAgent, realRemoteAddress);
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public void login(@Valid LoginForm form, HttpServletRequest request,
                      @RequestHeader(value = "User-Agent") String userAgent,
                      @RequestAttribute String realRemoteAddress) {

    }

    @RequestMapping(value = "signout", method = RequestMethod.PUT)
    public void sigOut(HttpServletRequest request) {
        signService.signOut(request);
    }
}