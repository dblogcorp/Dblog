package io.dblog.personal;

import io.dblog.common.server.BaseConfig;
import io.dblog.common.server.BaseServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * {@code Application}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Configuration
@ComponentScan
@Import({
        BaseConfig.class
})
public class Application {

    public static void main(String[] args) {
        BaseServer.run(Application.class, args);
    }
}
