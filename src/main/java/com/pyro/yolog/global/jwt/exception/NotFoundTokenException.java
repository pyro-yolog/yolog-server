package com.pyro.yolog.global.jwt.exception;

public class NotFoundTokenException extends RuntimeException {
    public NotFoundTokenException() {
    }

    public NotFoundTokenException(String message) {
        super(message);
    }

    public NotFoundTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}

