package com.ws.interceptor;

import com.ws.config.EnvironmentHelper;
import com.ws.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;



@Primary
@ResponseBody
@Controller
@ControllerAdvice
public class GlobalController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalController.class);

    public static final String ERROR_PATH = "/error";


    @Autowired
    private MessageSource messageSource;


    @Autowired
    private EnvironmentHelper environmentHelper;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("company", "companyId", "dateCreated", "lastUpdated");
    }


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


    @ExceptionHandler
    public JsonResponse handleBusinessException(BusinessException e) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(e.getMsgCode());
        jsonResponse.setMsg(messageSource.getMessage(e.getMsgCode(), e.getMsgArguments().toArray(), Locale.CHINESE));
        jsonResponse.setResultObject(e.getResultObject());
        return jsonResponse;
    }


    @ExceptionHandler
    JsonResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setIntCode(HttpStatus.BAD_REQUEST.value());
        jsonResponse.setMsg(e.getMessage());
        return jsonResponse;
    }


    @ExceptionHandler
    JsonResponse handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e,
                                                          HttpServletRequest request, HttpServletResponse response) {
        return handle400Error(e, request, response);
    }


    private JsonResponse handle400Error(Throwable e, HttpServletRequest request, HttpServletResponse response) {
        return  response(HttpStatus.BAD_REQUEST.value(), request, response, e);
    }

    /**
     * 处理404
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    public JsonResponse handle404Error(HttpServletRequest request, HttpServletResponse response) {
        return  response(HttpStatus.NOT_FOUND.value(), request, response, null);

    }


    @ExceptionHandler
    JsonResponse handle500Error(Throwable e, HttpServletRequest request, HttpServletResponse response) {
        return  response(HttpStatus.INTERNAL_SERVER_ERROR.value(), request, response, e);
    }


    private JsonResponse response(int httpState, HttpServletRequest request, HttpServletResponse response, Throwable e){

        LOGGER.error("httpState[{}],  uri[{}]", httpState, request.getRequestURI());

        response.setStatus(httpState);

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setIntCode(httpState);
        jsonResponse.setMsg(messageSource.getMessage(jsonResponse.getCode(), null, Locale.CHINESE));
        if(httpState==HttpStatus.INTERNAL_SERVER_ERROR.value()){
            if (!environmentHelper.isProductionEnvironment()){
                jsonResponse.setDetailErrors("{ " +
                        "\nmessage : " + e.getMessage() +
                        "\nstackTrace: " + getStackTraceString(e) +
                        "\n }");
            }

        }
        return jsonResponse;
    }


    private String getStackTraceString(Throwable e){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
