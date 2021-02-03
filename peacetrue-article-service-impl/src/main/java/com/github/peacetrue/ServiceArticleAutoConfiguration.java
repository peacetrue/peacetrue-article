package com.github.peacetrue;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

import java.util.Objects;

/**
 * @author xiayx
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ServiceArticleProperties.class)
@ComponentScan(basePackageClasses = ServiceArticleAutoConfiguration.class)
@PropertySource("classpath:/application-article-service.yml")
public class ServiceArticleAutoConfiguration {

    private ServiceArticleProperties properties;

    public ServiceArticleAutoConfiguration(ServiceArticleProperties properties) {
        this.properties = Objects.requireNonNull(properties);
    }

    @Bean
    @ConditionalOnMissingBean(R2dbcEntityOperations.class)
    public R2dbcEntityTemplate r2dbcEntityTemplate(DatabaseClient databaseClient) {
        return new R2dbcEntityTemplate(databaseClient);
    }
}
