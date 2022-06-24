package com.example.sociallogin.auth.infra.jwt;

import com.example.sociallogin.auth.dto.TokenResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final Map<String, Token> tokens;

    public TokenResponse createAccessToken(Long id) {
        Token accessToken = tokens.get(TokenType.ACCESS_TOKEN.name());
        return createToken(id, accessToken.secretKey(), accessToken.expiredAt());
    }

    public TokenResponse createRefreshToken(Long id) {
        Token refreshToken = tokens.get(TokenType.REFRESH_TOKEN.name());
        return createToken(id, refreshToken.secretKey(), refreshToken.expiredAt());
    }

    private TokenResponse createToken(Long id, String secretKey, Long expiredAt) {
        Date now = new Date();
        Date expire = new Date(now.getTime() + expiredAt);
        String token = Jwts.builder()
                .claim("id", id)
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return new TokenResponse(token, expiredAt);
    }

}
