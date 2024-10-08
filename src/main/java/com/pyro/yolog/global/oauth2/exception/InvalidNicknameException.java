package com.pyro.yolog.global.oauth2.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class InvalidNicknameException extends BusinessException {
    public InvalidNicknameException() {
        super(ErrorCode.DUPLICATED_NICKNAME_ERROR);
    }

}
