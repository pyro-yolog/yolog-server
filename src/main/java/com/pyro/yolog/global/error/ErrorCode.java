package com.pyro.yolog.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버에 오류가 발생했습니다."),

    // AUTH
    EMAIL_NOT_FOUND_ERROR(HttpStatus.FORBIDDEN, "이메일 추출에 실패했습니다."),
    DUPLICATED_NICKNAME_ERROR(HttpStatus.BAD_REQUEST, "이미 존재하는 닉네임입니다."),

    // MEMBER
    MEMBER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "회원 정보를 찾지 못했습니다." ),
    OWNER_NOT_EQUAL_ERROR(HttpStatus.BAD_REQUEST, "작성자만 접근 가능합니다."),

    // S3
    FILE_UPLOAD_FAILURE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S3 파일 업로드에 실패했습니다."),
    INVALID_FILE_EXTENSION_ERROR(HttpStatus.BAD_REQUEST, "잘못된 확장자의 파일 업로드를 시도했습니다."),
    FILE_DELETE_FAILURE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S3 파일 삭제에 실패했습니다."),

    // INQUIRY
    INQUIRY_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "해당 문의를 찾지 못했습니다."),
    INQUIRY_NOT_ADMIN_MEMBER_ERROR(HttpStatus.BAD_REQUEST, "문의하기 답변은 관리자만 가능합니다."),

    // TRIP
    TRIP_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "해당 일기장을 찾지 못했습니다."),
    REQUEST_COLOR_COVER_INVALID_ERROR(HttpStatus.BAD_REQUEST, "올바른 색상 코드를 입력해야 합니다."),

    //DIARY
    DIARY_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "해당 일기를 찾지 못했습니다."),
    REQUEST_WEATHER_NAME_INVALID_ERROR(HttpStatus.BAD_REQUEST, "올바른 날씨를 입력해야 합니다."),
    REQUEST_MOOD_NAME_INVALID_ERROR(HttpStatus.BAD_REQUEST, "올바른 기분을 입력해야 합니다."),
    ;
    private final HttpStatus status;
    private final String errorMessage;
}
