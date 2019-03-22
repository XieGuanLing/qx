package com.ws.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ws.http.HttpSessionStrategyImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.ExpiringSession;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * create by gl
 * on 2019/3/22
 */
@Configuration
public class SessionConfig {

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HttpSessionStrategyImpl();
    }

    @Primary
    @Bean
    public RedisTemplate<String, ExpiringSession> sessionRedisTemplate(JedisConnectionFactory factory) {
        RedisTemplate<String, ExpiringSession> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // customize the hash value serializer (default is JdkSerializationRedisSerializer)
        //template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper()));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        template.setConnectionFactory(factory);
        return template;
    }

}
