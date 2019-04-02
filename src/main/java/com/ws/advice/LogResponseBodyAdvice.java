package com.ws.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ws.filter.RequestAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * Created by gl on 2019/4/1.
 */
@ControllerAdvice
public class LogResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(LogResponseBodyAdvice.class);

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        String uri = (String)((ServletServerHttpRequest)request).getServletRequest().getAttribute(RequestAttributes.ORIGIN_REQUEST_URI);

        try {
            logger.debug("uri={} | responseBody={}", uri, objectMapper.writeValueAsString(body));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return body;
    }
}
