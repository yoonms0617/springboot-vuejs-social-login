package com.example.sociallogin.auth.infra.oauth.dto;

import com.example.sociallogin.auth.domain.SocialType;
import com.example.sociallogin.user.domain.User;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

import java.util.Map;

@Getter
public class KakaoOAuthInfo {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "kakao_account")
    private Map<String, Object> kakaoAccount;

    public User toUser() {
        return User.builder()
                .email((String) kakaoAccount.get("email"))
                .socialType(SocialType.KAKAO)
                .build();
    }

}
