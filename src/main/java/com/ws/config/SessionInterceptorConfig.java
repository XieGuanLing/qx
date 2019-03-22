package com.ws.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 */
@Component
@ConfigurationProperties(prefix = "interceptor.session")
public class SessionInterceptorConfig {


    private List<String> excludeSessionUrls;


    public List<String> getExcludeSessionUrls() {
        return excludeSessionUrls;
    }

    public void setExcludeSessionUrls(List<String> excludeSessionUrls) {
        this.excludeSessionUrls = excludeSessionUrls;
    }



    @Override
    public String toString() {
        return "SessionFilterConfig{" +
                ", excludeSessionUrls=" + excludeSessionUrls +
                '}';
    }
}
