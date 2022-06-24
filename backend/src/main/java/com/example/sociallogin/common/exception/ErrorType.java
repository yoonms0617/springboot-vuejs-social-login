package com.example.sociallogin.common.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    UN_SUPPORT_SOCIAL_TYPE("AUTH-001", "지원하지 않는 Social Type입니다."),
    INVALID_TOKEN("AUTH-002", "유효하지 않는 토큰입니다.");

    private final String code;
    private final String message;

    ErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
