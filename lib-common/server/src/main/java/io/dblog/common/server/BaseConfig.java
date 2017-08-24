package io.dblog.common.server;

import io.dblog.common.server.http.HttpConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Pelin on 17/6/19.
 */
@Import({
        PropertySourcesPlaceholderConfigurer.class,
        HttpConfig.class
})
@ComponentScan
public class BaseConfig {
}
