package io.dblog.common.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Pelin on 17/6/28.
 */
@ConfigurationProperties(prefix = "dblog.cache")
@Data
public class CacheSetting {

    private Integer maximumSize;

    private Integer expireTime;

    private Integer refreshTime;
}
