package io.dblog.common.server.http;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.http.HttpStatus;


@Import({
        ServerPropertiesAutoConfiguration.class,
        DispatcherServletAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
})
@EnableConfigurationProperties(HttpSetting.class)
public class HttpConfig {

    private static final Logger logger = LoggerFactory.getLogger(HttpConfig.class);

    private static volatile Server server;

    // Jetty HTTP Server
    //
    // see [1] on how to implement graceful shutdown in springboot.
    // Note that since use jetty, we need to use server.stop(), also StatisticsHandler must be
    // configured, for jetty graceful shutdown to work.
    //
    // [1]: https://github.com/spring-projects/spring-boot/issues/4657
    @Bean
    public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(
            HttpSetting httpSetting
    ) {
        logger.info("Jetty version: " + Server.getVersion());
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();

        factory.setPort(httpSetting.getPort());
        logger.info("Jetty configured on port: " + httpSetting.getPort());

        factory.addServerCustomizers(jettyServer -> {
            server = jettyServer;

            if (server.getThreadPool() instanceof QueuedThreadPool) {
                QueuedThreadPool threadPool = (QueuedThreadPool) server.getThreadPool();

                Integer maxThreads = httpSetting.getMaxThreads();
                if (null != maxThreads) {
                    logger.info("Jetty max threads: " + maxThreads);
                    threadPool.setMaxThreads(maxThreads);
                }

                Integer idleTimeout = httpSetting.getIdleTimeout();
                if (null != idleTimeout) {
                    threadPool.setIdleTimeout(idleTimeout);
                    logger.info("Jetty idle timeout: " + idleTimeout);
                }
            }

            Integer shutdownWaitTime = httpSetting.getShutdownWaitTime();
            if (shutdownWaitTime > 0) {
                StatisticsHandler handler = new StatisticsHandler();

                handler.setHandler(server.getHandler());
                server.setHandler(handler);

                logger.info("Shutdown wait time: " + shutdownWaitTime);
                server.setStopTimeout(shutdownWaitTime);

                // We will stop it through JettyGracefulShutdown class.
                server.setStopAtShutdown(false);
            }
        });

        factory.addErrorPages(
                new ErrorPage(HttpStatus.BAD_REQUEST, "/404"),
                new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
                new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500")
        );

        return factory;
    }

    @Bean
    public JettyGracefulShutdown jettyGracefulShutdown() {
        return new JettyGracefulShutdown();
    }

    private static class JettyGracefulShutdown implements ApplicationListener<ContextClosedEvent> {

        private static final Logger logger = LoggerFactory.getLogger(JettyGracefulShutdown.class);

        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            if (null == server) {
                logger.error("Jetty server is null, this should not happen!");
            }

            logger.info("Shutting down the Jetty server...");
            if (!(server.getHandler() instanceof StatisticsHandler)) {
                logger.error("Root handler is not StatisticHandler, graceful shutdown is not work at all");
            }

            StatisticsHandler handler = (StatisticsHandler) server.getHandler();
            logger.info("Active requests: " + handler.getRequestsActive());

            try {
                long begin = System.currentTimeMillis();
                server.stop();
                logger.info("Shutdown took " + (System.currentTimeMillis() - begin) + "ms.");
            } catch (Exception e) {
                logger.error("Failed to shutdown gracefully.", e);
            }
        }
    }


}
