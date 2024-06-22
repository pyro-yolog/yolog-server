package com.pyro.yolog.global.s3.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class InvalidFileExtensionException extends BusinessException {

    public InvalidFileExtensionException() {
        super(ErrorCode.INVALID_FILE_EXTENSION_ERROR);
    }
}
