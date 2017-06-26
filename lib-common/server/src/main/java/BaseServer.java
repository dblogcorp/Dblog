import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Pelin on 17/6/20.
 */
public abstract class BaseServer {

    public static ConfigurableApplicationContext run(Class clazz, String[] args) {
        SpringApplication application = new SpringApplication(clazz);

        application.addInitializers(context -> {
            if (context.getBeanFactory() instanceof DefaultListableBeanFactory) {
                ((DefaultListableBeanFactory) context.getBeanFactory()).setAllowBeanDefinitionOverriding(false);
            }
        });
        return application.run(args);
    }
}
