package io.dblog.sso.service.session;

import io.dblog.sso.entity.Account;
import lombok.Data;

import java.util.Date;

/**
 * {@code Session}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
public class Session {

    private Account account;

    private Boolean rememberMe;

    private Date lastActivity;

    private Date lastLogin;
}
