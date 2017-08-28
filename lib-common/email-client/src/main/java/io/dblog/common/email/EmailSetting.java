package io.dblog.common.email;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@ConfigurationProperties(prefix = "dblog.email")
public class EmailSetting {

    @Valid
    @NotNull
    private String url;
}
