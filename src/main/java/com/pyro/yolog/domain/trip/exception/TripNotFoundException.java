package com.pyro.yolog.domain.trip.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class TripNotFoundException extends BusinessException {
    public TripNotFoundException() {
        super(ErrorCode.TRIP_NOT_FOUND_ERROR);
    }
}
