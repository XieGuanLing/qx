package com.ws.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ws.misc.AutowireHelper;
import com.ws.platform.DateUtil;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

/**
 * Created by gl on 2019/4/1.
 *
 * @Configuration 中所有带 @Bean 注解的方法都会被动态代理，因此调用该方法返回的都是同一个实例。
 * @Component 注解并没有通过 cglib 来代理@Bean 方法的调用
 */

@Configuration
@EnableSwagger2
public class AppConfig {


    /**
     * ReloadableResourceBundleMessageSource不能使用正则匹配
     * 所以新增的文件需要手动添加
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:i18n/base-messages");
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
                .locations("db.migration", "com.ws.db.migration")
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
