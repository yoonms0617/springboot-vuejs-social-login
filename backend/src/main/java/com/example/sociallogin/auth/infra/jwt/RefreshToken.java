package com.example.sociallogin.auth.infra.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "REFRESH_TOKEN")
public class RefreshToken implements Token {

    @Value("${jwt.refresh-token.secret-key}")
    private String secretKey;

    @Value("${jwt.refresh-token.expire-time}")
    private Long expiredAt;

    @Override
    public String secretKey() {
        return secretKey;
    }

    @Override
    public Long expiredAt() {
        return expiredAt;
    }

}
