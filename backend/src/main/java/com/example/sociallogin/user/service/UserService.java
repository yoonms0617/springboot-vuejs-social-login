package com.example.sociallogin.user.service;

import com.example.sociallogin.auth.infra.jwt.TokenProvider;
import com.example.sociallogin.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;

    @Transactional(readOnly = true)
    public void profile() {

    }

}
