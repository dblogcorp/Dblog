package io.dblog.sso;

import io.dblog.common.db.DBConfig;
import io.dblog.common.email.EmailConfig;
import io.dblog.common.redis.RedisConfig;
import io.dblog.common.server.BaseConfig;
import io.dblog.common.server.BaseServer;
import io.dblog.sso.aspect.RequireRolesAspect;
import io.dblog.sso.config.JpaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Pelin on 17/8/1.
 */
@Import({
        BaseConfig.class,
        DBConfig.class,
        RedisConfig.class,
        EmailConfig.class,
        JpaConfig.class
})
@ComponentScan
@ServletComponentScan
@EnableAspectJAutoProxy
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        BaseServer.run(Application.class, args);
    }
}