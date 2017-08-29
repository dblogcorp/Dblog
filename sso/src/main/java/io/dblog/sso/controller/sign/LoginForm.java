package io.dblog.sso.controller.sign;

import io.dblog.sso.controller.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Pelin on 17/8/1.
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class LoginForm extends BaseForm {

    @NotBlank(message = "login.user.name.not.null")
    private String userName;

    @NotBlank(message = "login.password.nont.null")
    private String password;

    private String validateCode;
}
