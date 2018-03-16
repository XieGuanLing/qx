package com.ws.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * GlobalController hand404Error 其中的 request.getRequestURI() 不是原始的uri
 * 故添加该过滤器
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class Error404Filter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Error404Filter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            request.setAttribute(RequestAttributes.ORIGIN_REQUEST_URI, request.getRequestURI());
            filterChain.doFilter(request, response);

    }

}
