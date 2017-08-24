package io.dblog.common.db;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Created by Pelin on 17/7/24.
 */
@Data
@Component
@ConfigurationProperties(prefix = "jdbc")
public class DBSetting {

    @Valid
    @NotEmpty
    private String host;

    @Valid
    @NotEmpty
    private String database;

    @Valid
    @NotEmpty
    private String username;

    @Valid
    private String password;

    @Valid
    private Long leakDetectionThreshold = 0L;

    @Valid
    private Boolean showSql = false;

    @Valid
    private Integer timeout = 2000;
}
