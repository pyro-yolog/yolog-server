package com.pyro.yolog.domain.diary.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class RequestWeatherNameInvalidException extends BusinessException {
    public RequestWeatherNameInvalidException() {
        super(ErrorCode.REQUEST_WEATHER_NAME_INVALID_ERROR);
    }
}
