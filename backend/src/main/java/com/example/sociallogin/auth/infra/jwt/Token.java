package com.example.sociallogin.auth.infra.jwt;

public interface Token {

    String secretKey();

    Long expiredAt();

}
