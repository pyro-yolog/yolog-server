package com.pyro.yolog.domain.member.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class OwnerNotEqualException extends BusinessException {
    public OwnerNotEqualException() {
        super(ErrorCode.OWNER_NOT_EQUAL_ERROR);
    }
}
