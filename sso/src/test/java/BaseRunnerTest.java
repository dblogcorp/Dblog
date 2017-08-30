import io.dblog.sso.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@code BaseRunnerTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */

@RunWith(SpringRunner.class)
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "io.dblog")
@ContextConfiguration(classes = BaseRunnerTest.class, loader = AnnotationConfigContextLoader.class)
public class BaseRunnerTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testA() {
        System.out.println("测试");
        System.out.println(accountRepository);
    }

}
