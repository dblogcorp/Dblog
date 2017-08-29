package io.dblog.common.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * {@code EmailSetting} Email Client's Setting
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@ConfigurationProperties(prefix = "dblog.email")
@Data
public class EmailSetting {

    @Valid
    @NotNull
    private String url;
}
