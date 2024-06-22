package com.pyro.yolog.global.s3.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.ExternalApiException;

public class FileDeleteFailureException extends ExternalApiException {

    public FileDeleteFailureException() {
        super(ErrorCode.FILE_DELETE_FAILURE_ERROR);
    }
}
