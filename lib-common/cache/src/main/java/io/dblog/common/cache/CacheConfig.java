package io.dblog.common.cache;

import com.google.common.collect.Lists;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by Pelin on 17/6/28.
 */
@ComponentScan(basePackageClasses = CacheConfig.class)
public class CacheConfig {


    @Bean
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<CaffeineCache> cacheList = Lists.newArrayList();
        //for (Cache)

        return null;
    }
}
