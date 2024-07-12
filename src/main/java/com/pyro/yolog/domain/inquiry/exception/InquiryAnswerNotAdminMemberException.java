package com.pyro.yolog.domain.inquiry.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class InquiryAnswerNotAdminMemberException extends BusinessException {
    public InquiryAnswerNotAdminMemberException() {
        super(ErrorCode.INQUIRY_NOT_ADMIN_MEMBER_ERROR);
    }
}
