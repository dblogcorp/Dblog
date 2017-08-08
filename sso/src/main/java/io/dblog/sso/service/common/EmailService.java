package io.dblog.sso.service.common;

import io.dblog.common.email.inter.EmailClientEnum;
import io.dblog.common.email.inter.EmailClientService;
import io.dblog.sso.entity.Account;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@code EmailService}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private EmailClientService emailClientService;

    public void sendRegisterEmail(Account account) {
        String email = account.getEmail();
        if (StringUtils.isBlank(email)) {
            logger.error("Email Send Error: user's email is null, user_name=" + account.getUserName());
        }

        emailClientService.sendEmail(
                EmailClientEnum.TOPIC_REGISTER,
                EmailClientEnum.TYPE_ASYNC,
                email
        );
    }
}
