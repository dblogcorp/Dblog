package io.dblog.sso;

import io.dblog.common.server.BaseServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Pelin on 17/8/1.
 */
@Configuration
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    

    public static void main(String[] args) {
        BaseServer.run(Application.class, args);
    }
}
