package com.ws.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ws.interceptor.JsonModule;
import com.ws.platform.DateUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

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
