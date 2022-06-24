package com.example.sociallogin.auth.infra.oauth;

import com.example.sociallogin.user.domain.User;

public interface OAuthClient {

    User getUserInfo(String authorizationCode);

}
