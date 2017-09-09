package io.dblog.sso.service.session;

import io.dblog.jpa.sso.entity.Account;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * {@code Session}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
public class Session implements Serializable {

    private Account account;

    private Boolean rememberMe;

    private Date lastActivity;

    private Date lastLogin;
}
