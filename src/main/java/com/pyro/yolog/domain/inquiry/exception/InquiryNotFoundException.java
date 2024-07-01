package com.pyro.yolog.domain.inquiry.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class InquiryNotFoundException extends BusinessException {
    public InquiryNotFoundException() {
        super(ErrorCode.INQUIRY_NOT_FOUND_ERROR);
    }
}
