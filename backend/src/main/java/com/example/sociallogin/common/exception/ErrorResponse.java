package com.example.sociallogin.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ErrorResponse {

    private LocalDateTime timeStamp;
    private String code;
    private String message;

    private ErrorResponse(String code, String message) {
        this.timeStamp = LocalDateTime.now();
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse of(ErrorType errorType) {
        return new ErrorResponse(errorType.getCode(), errorType.getMessage());
    }

}
