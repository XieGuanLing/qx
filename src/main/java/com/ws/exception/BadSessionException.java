package com.ws.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by gl on 2019/4/1.
 */
public class BadSessionException extends BaseException {

    private String code;

    private String message;

    public BadSessionException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BadSessionException(HttpStatus status, String message) {
        this(String.valueOf(status.value()), message);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
