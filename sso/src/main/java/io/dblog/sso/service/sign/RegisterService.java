package io.dblog.sso.service.sign;

import io.dblog.common.exception.BadRequestException;
import io.dblog.common.role.RoleEnum;
import io.dblog.common.util.EncryptUtils;
import io.dblog.jpa.sso.entity.Account;
import io.dblog.proto.sso.api.AccountProto;
import io.dblog.sso.constant.AccountConstant;
import io.dblog.sso.controller.sign.RegisterForm;
import io.dblog.sso.service.account.AccountService;
import io.dblog.sso.service.common.EmailService;
import io.dblog.sso.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Pelin on 17/8/1.
 */
@Service
public class RegisterService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LoginService loginService;

    @Transactional
    public AccountProto.Account register(HttpServletRequest request, RegisterForm form,
                                         String userAgent, String registerIp) throws NoSuchAlgorithmException {
        String email = form.getEmail();
        String userName = form.getUserName();
        if (accountService.checkAccountExists(userName, email)) {
            throw new BadRequestException("register.account.existed");
        }

        Account account = new Account();
        account.setStatus(AccountConstant.STATUS_INACTIVED);
        account.setUserName(form.getUserName());
        account.setName(form.getUserName());
        account.setEmail(form.getEmail());
        account.setPassword(
                EncryptUtils.SHA256(
                        form.getPassword(),
                        form.getUserName()
                )
        );
        account.setRole(RoleEnum.GENERAL.getId());
        account.setGravatar("");
        account.setEmailValidation(false);
        account.setUserAgent(userAgent);
        account.setRegisterIp(registerIp);
        if (!accountService.save(account)) {
            throw new BadRequestException("register.account.save.failed");
        }
        emailService.sendRegisterEmail(account);

        String authId = CookieUtils.getAuthId(request);
        loginService.updateLoginSession(account, authId);

        return accountService.toProto(account);
    }
}
