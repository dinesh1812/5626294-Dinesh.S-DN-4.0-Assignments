package com.example.token.service;

import com.example.token.model.TokenGenerator;
import java.util.*;

public class TokenService {
    private final TokenGenerator tokenGenerator;

    public TokenService(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
    }

    public List<String> fetchTokens(int count) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tokens.add(tokenGenerator.generateToken());
        }
        return tokens;
    }
}