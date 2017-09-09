package io.dblog.sso.repository;

import io.dblog.common.db.DBConfig;
import io.dblog.sso.config.JpaConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * {@code BaseRepositoryTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        DBConfig.class,
        JpaConfig.class
})
@SpringBootTest(classes = {
        AccountRepositoryTest.class
})
@TestPropertySource(locations = "classpath:test.properties")
public abstract class BaseRepositoryTest {
}
