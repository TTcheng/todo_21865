package com.wcc.base.exception;

public class BusinessException extends Exception {
    private static final long serialVersionUID = -2858803856620104250L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
