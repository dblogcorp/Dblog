package http;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Pelin on 17/6/20.
 */
@ConfigurationProperties(prefix = "dblog.http")
@Data
public class HttpSetting {

    @Valid
    @NotNull
    private Integer port;

    @Valid
    @NotNull
    private Integer shutdownWaitTime = 30;

    @Valid
    @NotNull
    private Integer maxThreads;

    @Valid
    @NotNull
    private Integer idleTimeout;
}
