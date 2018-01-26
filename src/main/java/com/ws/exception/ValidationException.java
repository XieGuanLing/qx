package com.ws.exception;

import com.ws.config.FieldResolver;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;
import java.util.Objects;


public class ValidationException extends BaseException {

    private Errors errors;

    private FieldResolver fieldResolver;

    public ValidationException(@NotNull Errors errors, FieldResolver fieldResolver) {
        super(errors.getAllErrors().toString());
        Objects.requireNonNull(errors);
        this.errors = errors;
        this.fieldResolver = fieldResolver;
    }

    public ValidationException(@NotNull Errors errors) {
        super(errors.getAllErrors().toString());
        Objects.requireNonNull(errors);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    public FieldResolver getFieldResolver() {
        return fieldResolver;
    }
}
