package com.ws.interceptor;

import com.ws.config.SessionInterceptorConfig;
import com.ws.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 */
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    HttpSessionStrategy httpSessionStrategy;


    private Set<Pattern> excludeSessionUrlPatterns = new HashSet<>();


    @Autowired
    public SessionInterceptor( SessionInterceptorConfig sessionInterceptorConfig) {
        sessionInterceptorConfig.getExcludeSessionUrls().forEach(urlPattern ->
                excludeSessionUrlPatterns.add(Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE))
        );
    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request, response), true);
        return check(request, response);
    }

    private Boolean check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getRequestURI();
        for (Pattern p : excludeSessionUrlPatterns) {
            if (p.matcher(path).matches()) {
                return true;
            }
        }
        String sid = httpSessionStrategy.getRequestedSessionId(request);
        if(StringUtils.isBlank(sid)){
            throw new BusinessException("ISM00001");
        }else{
            return true;
        }

    }
}
