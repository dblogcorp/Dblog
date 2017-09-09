package io.dblog.common.redis;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * {@code BaseRedisTest}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        RedisManagerTest.class
})
@Import({
        RedisConfig.class,
})
@TestPropertySource(locations = "classpath:test.properties")
public class BaseRedisTest {
}
