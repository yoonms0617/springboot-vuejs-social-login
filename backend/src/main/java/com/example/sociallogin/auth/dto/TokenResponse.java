package com.example.sociallogin.auth.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TokenResponse {

    private String token;
    private Long expiredAt;

    public TokenResponse(String token, Long expiredAt) {
        this.token = token;
        this.expiredAt = expiredAt;
    }

}
