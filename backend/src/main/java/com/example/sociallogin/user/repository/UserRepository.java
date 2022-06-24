package com.example.sociallogin.user.repository;

import com.example.sociallogin.auth.domain.SocialType;
import com.example.sociallogin.user.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndSocialType(String email, SocialType socialType);

    Optional<User> findByEmail(String email);

}
