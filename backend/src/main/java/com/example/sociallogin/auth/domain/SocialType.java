package com.example.sociallogin.auth.domain;

import com.example.sociallogin.auth.exception.UnsupportedSocialTypeExcepion;

import java.util.Arrays;

public enum SocialType {

    KAKAO, NAVER, GOOGLE;

    public static SocialType of(String provider) {
        return Arrays.stream(SocialType.values())
                .filter(socialType -> socialType.name().equals(provider.toUpperCase()))
                .findFirst()
                .orElseThrow(UnsupportedSocialTypeExcepion::new);
    }

}
