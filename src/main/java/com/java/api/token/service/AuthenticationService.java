package com.java.api.token.service;

import com.java.api.token.entity.Authenticate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public Authenticate authenticate(Authentication authentication) {
        Authenticate auth = new Authenticate(jwtService.generateToken(authentication));
        return auth;
    }
}
