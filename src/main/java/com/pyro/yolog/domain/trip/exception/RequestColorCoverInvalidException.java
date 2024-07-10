package com.pyro.yolog.domain.trip.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class RequestColorCoverInvalidException extends BusinessException {
    public RequestColorCoverInvalidException() {
        super(ErrorCode.REQUEST_COLOR_COVER_INVALID_ERROR);
    }
}
