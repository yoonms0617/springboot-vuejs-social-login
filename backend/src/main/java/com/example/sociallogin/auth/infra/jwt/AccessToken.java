package com.example.sociallogin.auth.infra.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "ACCESS_TOKEN")
public class AccessToken implements Token {

    @Value("${jwt.access-token.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token.expire-time}")
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
