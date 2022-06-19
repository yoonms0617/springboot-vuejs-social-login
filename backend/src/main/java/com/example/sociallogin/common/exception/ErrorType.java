package com.example.sociallogin.common.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    ;

    private final String code;
    private final String message;

    ErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
