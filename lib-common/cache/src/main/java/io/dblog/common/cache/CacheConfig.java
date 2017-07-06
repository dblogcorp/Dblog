package io.dblog.common.cache;

import io.dblog.common.redis.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Method;

/**
 * Created by Pelin on 17/6/28.
 */
@Import({
      RedisConfig.class,
})
@ComponentScan(basePackageClasses = CacheConfig.class)
public class CacheConfig extends CachingConfigurerSupport {

    private final static Logger logger = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder builder = new StringBuilder();

                builder.append(target.getClass().getSimpleName());
                builder.append(method.getName());
                for (Object obj : params) {
                    builder.append(obj.toString());
                }

                String key = builder.toString();
                logger.info("Cache key be generated: " +key);
                return key;
            }
        };
    }
}
