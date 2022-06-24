package com.example.sociallogin.auth.infra.oauth;

import com.example.sociallogin.auth.infra.oauth.dto.KakaoOAuthInfo;
import com.example.sociallogin.auth.infra.oauth.dto.OAuthTokenResponse;
import com.example.sociallogin.user.domain.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Component(value = "KAKAO")
public class KakaoOAuthClient implements OAuthClient {

    @Value("${oauth.kakao.client-id}")
    private String clientId;

    @Value("${oauth.kakao.client-secret}")
    private String clientSecret;

    @Value("${oauth.kakao.redirect-uri}")
    private String redirectUri;

    @Value("${oauth.kakao.token-uri}")
    private String tokenUri;

    @Value("${oauth.kakao.user-info-uri}")
    private String userInfoUri;

    @Override
    public User getUserInfo(String authorizationCode) {
        OAuthTokenResponse oAuthTokenResponse = getOAuthTokenResponse(authorizationCode);
        KakaoOAuthInfo kakaoOAuthInfo = WebClient.create(userInfoUri)
                .post()
                .headers(httpHeaders -> {
                    httpHeaders.set("Authorization", "Bearer " + oAuthTokenResponse.getAccessToken());
                    httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                })
                .retrieve()
                .bodyToMono(KakaoOAuthInfo.class)
                .block();
        return Objects.requireNonNull(kakaoOAuthInfo).toUser();
    }

    private OAuthTokenResponse getOAuthTokenResponse(String authorizationCode) {
        return WebClient.create(tokenUri)
                .post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", clientId)
                        .queryParam("redirect_uri", redirectUri)
                        .queryParam("code", authorizationCode)
                        .queryParam("client_secret", clientSecret)
                        .build()
                )
                .headers(httpHeaders -> httpHeaders
                        .set("Content-type", "application/x-www-form-urlencoded;charset=utf-8")
                )
                .retrieve()
                .bodyToMono(OAuthTokenResponse.class)
                .block();
    }

}
