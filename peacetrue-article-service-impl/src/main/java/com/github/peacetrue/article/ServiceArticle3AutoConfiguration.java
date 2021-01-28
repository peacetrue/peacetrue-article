package com.github.peacetrue.article;

import com.github.peacetrue.dictionary.modules.dictionaryvalue.DictionaryValueRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
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
@EnableConfigurationProperties(ServiceArticle3Properties.class)
@ComponentScan(basePackageClasses = ServiceArticle3AutoConfiguration.class)
@PropertySource("classpath:/application-article3-service.yml")
public class ServiceArticle3AutoConfiguration {

    private ServiceArticle3Properties properties;

    public ServiceArticle3AutoConfiguration(ServiceArticle3Properties properties) {
        this.properties = Objects.requireNonNull(properties);
    }

    @Bean
    @ConditionalOnMissingBean(R2dbcEntityOperations.class)
    public R2dbcEntityTemplate r2dbcEntityTemplate(DatabaseClient databaseClient) {
        return new R2dbcEntityTemplate(databaseClient);
    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(DictionaryValueRepository.class)
    public static class DictionaryValueDependency {
        @Bean
        @ConditionalOnBean(DictionaryValueRepository.class)
        public Article3Listener articleListener() {
            return new Article3Listener();
        }
    }
}
