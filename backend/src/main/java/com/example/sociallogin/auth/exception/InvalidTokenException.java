package com.example.sociallogin.auth.exception;

import com.example.sociallogin.common.exception.BaseException;
import com.example.sociallogin.common.exception.ErrorType;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends BaseException {

    public InvalidTokenException() {
        super(ErrorType.INVALID_TOKEN, HttpStatus.UNAUTHORIZED);
    }

}
