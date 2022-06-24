package com.example.sociallogin.auth.exception;

import com.example.sociallogin.common.exception.BaseException;
import com.example.sociallogin.common.exception.ErrorType;

import org.springframework.http.HttpStatus;

public class UnsupportedSocialTypeExcepion extends BaseException {

    public UnsupportedSocialTypeExcepion() {
        super(ErrorType.UN_SUPPORT_SOCIAL_TYPE, HttpStatus.NOT_FOUND);
    }

}
