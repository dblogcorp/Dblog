package io.dblog.common.email;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * {@code EmailSetting} Email Client's Setting
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@Component
public class EmailSetting {

    @Valid
    @NotNull
    @Value("${dblog.email.url}")
    private String emailSendUrl;
}
