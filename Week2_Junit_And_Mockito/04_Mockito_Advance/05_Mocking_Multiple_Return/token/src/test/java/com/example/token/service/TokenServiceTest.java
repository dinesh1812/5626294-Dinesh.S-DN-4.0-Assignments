package com.example.token.service;

import org.junit.jupiter.api.Test;

import com.example.token.model.TokenGenerator;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TokenServiceTest {

    @Test
    void testFetchTokensWithMultipleReturnValues() {
        // Mock TokenGenerator
        TokenGenerator mockGenerator = mock(TokenGenerator.class);

        // Stub with multiple return values
        when(mockGenerator.generateToken())
            .thenReturn("TKN1")
            .thenReturn("TKN2")
            .thenReturn("TKN3");

        // Inject mock and verify
        TokenService tokenService = new TokenService(mockGenerator);
        List<String> tokens = tokenService.fetchTokens(3);

        assertEquals(List.of("TKN1", "TKN2", "TKN3"), tokens);
    }
}