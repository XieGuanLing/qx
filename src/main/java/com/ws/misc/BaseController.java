package com.ws.misc;

import com.ws.exception.ValidationException;
import com.ws.advice.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;

import java.util.Locale;
import java.util.function.Supplier;

public class BaseController {

    private static final Logger logger = Logger.getLogger(BaseController.class);

    private static final String SUCCESSFUL_MESSAGE_CODE = "ISM00000";

    @Autowired
    protected MessageSource messageSource;

    protected JsonResponse response(String msgCode) {
        return response(msgCode, (Object) null);
    }

    protected JsonResponse response(Object resultObject) {
        return response(SUCCESSFUL_MESSAGE_CODE, resultObject);
    }

    protected JsonResponse response(String msgCode, Object resultObject) {
        JsonResponse jr = new JsonResponse();
        jr.setSuccess(true);
        jr.setResultObject(resultObject);
        jr.setCode(msgCode != null ? msgCode : SUCCESSFUL_MESSAGE_CODE);
        jr.setMsg(messageSource.getMessage(jr.getCode(), null, Locale.CHINESE));
        return jr;
    }

    protected <R> JsonResponse<R> response(String msgCode, Supplier<R> supplier) {
        JsonResponse<R> jr = new JsonResponse<R>();
        jr.setSuccess(true);
        jr.setResultObject(supplier.get());
        jr.setCode(msgCode);
        jr.setMsg(messageSource.getMessage(jr.getCode(), null, Locale.CHINESE));
        return jr;
    }

    protected <R> JsonResponse<R> response(Supplier<R> supplier) {
        return response(SUCCESSFUL_MESSAGE_CODE, supplier);
    }

    protected <R> JsonResponse<R> responseVoid() {
        return responseVoid(() -> {
        });
    }

    protected <R> JsonResponse<R> responseVoid(Runnable callback) {
        return response((Supplier<R>) () -> {
            callback.run();
            return null;
        });
    }


    protected <R> JsonResponse<R> responseVoid(BindingResult bindingResult, Runnable callback) {
        return response(bindingResult, () -> {
            callback.run();
            return null;
        });
    }


    /**
     * 不需要 FieldResolver
     *
     * @param bindingResult
     * @param supplier
     * @param <R>
     * @return
     * @since v5.0.0
     */
    protected <R> JsonResponse<R> response(BindingResult bindingResult, Supplier<R> supplier) {
        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult);

        return response(supplier);
    }
}
