package com.ws.config;

import com.google.common.collect.ImmutableSet;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 */
@Import(BeanValidatorPluginsConfiguration.class)
//@Profile({"test", "local"})
@EnableSwagger2
@Configuration
public class Swagger2Config {


    @Autowired
    private EnvironmentHelper environmentHelper;



    @Bean
    public ApiInfo superManagerApiInfo() {
        return new ApiInfoBuilder()
                .title("超级API")
                .description("超级项目API接口文档")
                .version("1.0.0")
                .contact(new Contact("gl", null, ""))
                .build();
    }

    @Bean
    public Docket superManagerApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .groupName("SuperManager")
                .useDefaultResponseMessages(false)
                .ignoredParameterTypes(HttpSession.class, BindingResult.class, HttpServletRequest.class, HttpServletResponse.class)
                .directModelSubstitute(Date.class, String.class)
                .directModelSubstitute(java.sql.Date.class, String.class)
                .consumes(ImmutableSet.of(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .produces(ImmutableSet.of(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .protocols(ImmutableSet.of("http", "https"))
                .forCodeGeneration(false)
                .tags(new Tag("SuperManager", "超级"))
                .apiInfo(superManagerApiInfo());

        return docket;
    }

    @Bean
    public UiConfiguration uiConfig() {
        return new UiConfiguration(
                "",// url
                "list",       // docExpansion          => none | list
                "alpha",      // apiSorter             => alpha
                "schema",     // defaultModelRendering => schema
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                false,        // enableJsonEditor      => true | false
                true);        // showRequestHeaders    => true | false
    }

}
