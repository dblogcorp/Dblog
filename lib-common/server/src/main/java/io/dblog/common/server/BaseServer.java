package io.dblog.common.server;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.nio.charset.Charset;

/**
 * Created by Pelin on 17/6/20.
 */
public abstract class BaseServer {

    public static ConfigurableApplicationContext run(Class clazz, String[] args) {
        checkUTF8();

        SpringApplication application = new SpringApplication(clazz);
        application.addInitializers(context -> {
            if (context.getBeanFactory() instanceof DefaultListableBeanFactory) {
                ((DefaultListableBeanFactory) context.getBeanFactory()).setAllowBeanDefinitionOverriding(false);
            }
        });
        return application.run(args);
    }

    private static void checkUTF8() {
        if (!"UTF-8".equalsIgnoreCase(Charset.defaultCharset().toString())) {
            System.err.println();
            System.err.println("[ERROR] ------------------------------------------------------------------------");
            System.err.println("[ERROR] system encoding is not UTF-8!");
            System.err.println("[ERROR] ------------------------------------------------------------------------");
            System.exit(1);
        }
    }
}
