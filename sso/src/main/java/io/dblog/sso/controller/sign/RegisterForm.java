package io.dblog.sso.controller.sign;

import io.dblog.common.util.PatternUtils;
import io.dblog.sso.controller.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.Errors;

import javax.validation.constraints.Size;

/**
 * Created by Pelin on 17/8/1.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterForm extends BaseForm {

    @NotBlank(message = "register.user.name.not.null")
    @Size(min = 1, max = 30)
    private String userName;

    @NotBlank(message = "register.email.not.null")
    @Size(min = 3, max = 320)
    private String email;

    @NotBlank(message = "register.password.not.null")
    @Size(min = 6, max= 72)
    private String password;

    @NotBlank(message = "register.repeat.password.not.null")
    @Size(min = 6, max= 72)
    private String repeatPassword;

    private String validateCode;

    @Override
    public void validate(Object target, Errors errors) {
        if (PatternUtils.checkUserName(userName)) {
            rejectValue(errors, "userNameErrorFormat", "register.user.name.format.error");
        }

        if (PatternUtils.checkEmail(email)) {
            rejectValue(errors, "userNameErrorFormat", "register.user.email.format.error");
        }

        if (!password.equals(repeatPassword)) {
            rejectValue(errors, "repeatPassword", "register.repeat.password.not.equaled");
        }
    }
}
