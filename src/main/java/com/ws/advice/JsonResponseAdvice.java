package com.ws.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by gl on 2019/4/1.
 *
 * Allows customizing the response after the execution of an @ResponseBody or a ResponseEntity
 * controller method but before the body is written with an HttpMessageConverter.
 *
 * Implementations may be may be registered directly with RequestMappingHandlerAdapter and
 * ExceptionHandlerExceptionResolver or more likely annotated with @ControllerAdvice in which
 * case they will be auto-detected by both.
 */

@Order(0)
@ControllerAdvice
public class JsonResponseAdvice implements ResponseBodyAdvice<JsonResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonResponseAdvice.class);


    @Override
    public JsonResponse beforeBodyWrite(JsonResponse body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        return body;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return JsonResponse.class == returnType.getParameterType();
    }
}
