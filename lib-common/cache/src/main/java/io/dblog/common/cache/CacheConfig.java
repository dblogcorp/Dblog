package io.dblog.common.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pelin on 17/6/28.
 */
@ComponentScan(basePackageClasses = CacheConfig.class)
public class CacheConfig {

    private final static Logger logger = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        cacheManager.setAllowNullValues(false);
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        .initialCapacity(100)
                        .maximumSize(10_000)
                        .expireAfterAccess(5, TimeUnit.MINUTES)
                        .removalListener(new CustomRemovalListener())
                        .recordStats()
        );
        return cacheManager;
    }

    private class CustomRemovalListener implements RemovalListener<Object, Object> {

        @Override
        public void onRemoval(@Nullable Object key, @Nullable Object value, @Nonnull RemovalCause cause) {
            logger.warn("Cache Removal-Listener called with key [%s], cause [%s], evicted [%S]",
                    key, cause.toString(), cause.wasEvicted());
        }
    }
}
