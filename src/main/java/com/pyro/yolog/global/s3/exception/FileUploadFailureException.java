package com.pyro.yolog.global.s3.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.ExternalApiException;

public class FileUploadFailureException extends ExternalApiException {

    public FileUploadFailureException() {
        super(ErrorCode.FILE_UPLOAD_FAILURE_ERROR);
    }
}
