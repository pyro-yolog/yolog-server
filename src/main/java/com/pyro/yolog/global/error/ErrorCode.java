package com.pyro.yolog.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버에 오류가 발생했습니다."),

    // MEMBER
    MEMBER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "회원 정보를 찾지 못했습니다." ),

    // S3
    FILE_UPLOAD_FAILURE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S3 파일 업로드에 실패했습니다."),
    INVALID_FILE_EXTENSION_ERROR(HttpStatus.BAD_REQUEST, "잘못된 확장자의 파일 업로드를 시도했습니다."),
    FILE_DELETE_FAILURE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S3 파일 삭제에 실패했습니다.");

    private final HttpStatus status;
    private final String errorMessage;
}
