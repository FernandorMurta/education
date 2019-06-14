package com.frmurta.hackathon.exception;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CustomException extends RuntimeException {

    private List<String> errors = new ArrayList<>();

    public CustomException() {
    }

    public CustomException(List<String> errors) {
        this.errors = errors;
    }

    public void addMessage(String message) {
        if (CollectionUtils.isEmpty(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(message);
    }


    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public boolean hasErrors() {
        return !CollectionUtils.isEmpty(errors);
    }

    public List<String> getErrors() {
        return errors;
    }

    public static Supplier<CustomException> throwMessage(String message) {
        return () -> new CustomException(message);
    }
}
