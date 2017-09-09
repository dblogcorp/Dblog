package io.dblog.sso.service;

import io.dblog.common.db.DBConfig;
import io.dblog.common.email.EmailConfig;
import io.dblog.common.redis.RedisConfig;
import io.dblog.sso.config.JpaConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * {@code BaseService}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        SessionStoreTest.class
})
@Import({
        DBConfig.class,
        EmailConfig.class,
        RedisConfig.class,
        JpaConfig.class
})
@TestPropertySource(locations = "classpath:test.properties")
@ComponentScan
public abstract class BaseServiceTest {
}
