package com.ws.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ws.advice.JsonModule;
import com.ws.misc.AutowireHelper;
import com.ws.platform.DateUtil;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.sql.DataSource;

/**
 * Created by gl on 2017/9/18.
 *
 * 如果不加@ComponentScan(basePackages = "com.ws") ，
 * idea 会提示 "JsonModule， EnvironmentHelper " not found
 */

@Configuration
@ComponentScan(basePackages = "com.ws")
public class AppConfig {

    /**
     * ReloadableResourceBundleMessageSource不能使用正则匹配
     * 所以新增的文件需要手动添加
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/base-messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public AutowireHelper autowireHelper() {
        return AutowireHelper.getInstance();
    }



    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource ds  = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3307/qx");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setInitialSize(1);
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setMaxActive(1200);
        ds.setMinEvictableIdleTimeMillis(3600000);
        ds.setTimeBetweenEvictionRunsMillis(3600000);
        ds.setNumTestsPerEvictionRun(3);
        ds.setTestOnBorrow(true);
        ds.setTestWhileIdle(true);
        ds.setTestOnReturn(false);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultTransactionIsolation(2);
        return ds;
    }


    @Bean
    public FlywayMigrationInitializer flywayInitializer(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("db.migration")
                .outOfOrder(true)
                .baselineOnMigrate(true)
                .load();
        return new FlywayMigrationInitializer(
                flyway,
                null
        );
    }


    @Bean
    @Primary
    public ObjectMapper objectMapper(JsonModule jsonModule, EnvironmentHelper environmentHelper) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                .indentOutput(!environmentHelper.isProductionEnvironment())
                .simpleDateFormat(DateUtil.DATE_TIME_FORMAT_PATTERN)
                .featuresToDisable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
                );

        return builder.build()
                .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)
                .registerModule(jsonModule);

    }
}
