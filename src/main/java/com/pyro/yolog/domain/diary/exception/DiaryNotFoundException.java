package com.pyro.yolog.domain.diary.exception;

import com.pyro.yolog.global.error.ErrorCode;
import com.pyro.yolog.global.error.exception.BusinessException;

public class DiaryNotFoundException extends BusinessException {
    public DiaryNotFoundException() {
        super(ErrorCode.DIARY_NOT_FOUND_ERROR);
    }
}
