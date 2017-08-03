package io.dblog.sso.controller.sign;

import io.dblog.sso.service.sign.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Pelin on 17/8/1.
 */
@RestController
@RequestMapping(value = "/api/v1/sign")
public class SignController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public void register(@Valid RegisterForm form, HttpServletRequest request,
                      @RequestHeader(value = "User-Agent") String userAgent,
                      @RequestAttribute String realRemoteAddress) {
        registerService.register(request, form);
    }

    @RequestMapping(value = "/in", method = RequestMethod.POST)
    public void login(@Valid LoginForm form, HttpServletRequest request,
                      @RequestHeader(value = "User-Agent") String userAgent,
                      @RequestAttribute String realRemoteAddress) {

    }
}