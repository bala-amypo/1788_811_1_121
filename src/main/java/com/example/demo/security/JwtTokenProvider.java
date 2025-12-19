package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(Long userId, String email, String role) {
        // Minimal implementation just to compile
        return "jwt-token-" + userId;
    }
}
