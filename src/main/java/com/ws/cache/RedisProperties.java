package com.ws.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * create by gl
 * on 2019/4/4
 */
@Primary
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties extends org.springframework.boot.autoconfigure.data.redis.RedisProperties {

}
