package com.pyro.yolog.domain.diary.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class RequestMoodNameInvalidException extends BusinessException {
    public RequestMoodNameInvalidException() {
        super(ErrorCode.REQUEST_MOOD_NAME_INVALID_ERROR);
    }
}
