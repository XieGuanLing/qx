package com.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gl on 2017/9/18.
 * 这里必须有ComponentScan，否则扫描不到其他配置
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ws")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }


}