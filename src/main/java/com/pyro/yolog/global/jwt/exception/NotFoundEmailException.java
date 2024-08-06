package com.pyro.yolog.global.jwt.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class NotFoundEmailException extends BusinessException {
    public NotFoundEmailException() {
        super(ErrorCode.EMAIL_NOT_FOUND_ERROR);
    }
}