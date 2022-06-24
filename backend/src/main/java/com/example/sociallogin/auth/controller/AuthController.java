package com.example.sociallogin.auth.controller;

import com.example.sociallogin.auth.dto.TokenResponse;
import com.example.sociallogin.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/oauth/login/{provider}")
    public ResponseEntity<?> socialLogin(@PathVariable(value = "provider") String provider,
                                         @RequestParam(value = "code") String authorizationCode) {
        TokenResponse accessToken = authService.socialLogin(provider, authorizationCode);
        return ResponseEntity.ok(accessToken);
    }

}
