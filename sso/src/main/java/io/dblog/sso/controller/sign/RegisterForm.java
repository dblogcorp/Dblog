package io.dblog.sso.controller.sign;

import io.dblog.sso.BaseForm;
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

    @NotBlank(message = "register.email.nont.null")
    @Size(min = 6, max = 32)
    private String email;

    @NotBlank(message = "register.password.nont.null")
    @Size(min = 7, max= 72)
    private String password;

    @NotBlank(message = "register.repeat.password.nont.null")
    @Size(min = 7, max= 72)
    private String repeatPassword;

    private String validateCode;

    @Override
    public void validate(Object target, Errors errors) {
        if (!password.equals(repeatPassword)) {
            rejectValue(errors, "repeatPassword", "register.repeat.password.not.equaled");
        }
    }
}
