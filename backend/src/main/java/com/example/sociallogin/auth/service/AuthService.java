package com.example.sociallogin.auth.service;

import com.example.sociallogin.auth.domain.SocialType;
import com.example.sociallogin.auth.dto.TokenResponse;
import com.example.sociallogin.auth.infra.jwt.TokenProvider;
import com.example.sociallogin.auth.infra.oauth.OAuthClient;
import com.example.sociallogin.user.domain.User;
import com.example.sociallogin.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final Map<String, OAuthClient> oAuthClients;

    @Transient
    public TokenResponse socialLogin(String provider, String authorizationCode) {
        SocialType socialType = SocialType.of(provider);
        OAuthClient oAuthClient = oAuthClients.get(socialType.name());
        User userInfo = oAuthClient.getUserInfo(authorizationCode);
        User user = userRepository.findByEmailAndSocialType(userInfo.getEmail(), userInfo.getSocialType())
                .orElseGet(() -> userRepository.save(userInfo));
        return tokenProvider.createAccessToken(user.getId());
    }

}
