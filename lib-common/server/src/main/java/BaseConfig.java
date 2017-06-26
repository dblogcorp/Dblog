import http.HttpConfig;
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
@ComponentScan(
        basePackageClasses = {
                BaseServer.class
        }
)
public class BaseConfig {
}
