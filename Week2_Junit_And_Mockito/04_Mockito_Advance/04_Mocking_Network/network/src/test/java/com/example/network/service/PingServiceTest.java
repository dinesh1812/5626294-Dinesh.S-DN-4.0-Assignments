package com.example.network.service;

import org.junit.jupiter.api.Test;

import com.example.network.model.NetworkClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PingServiceTest {

    @Test
    void testCheckServerUp() {
        // Create mock NetworkClient
        NetworkClient mockClient = mock(NetworkClient.class);

        // Stub method to simulate success
        when(mockClient.isReachable("http://example.com")).thenReturn(true);

        // Test service logic
        PingService service = new PingService(mockClient);
        String result = service.checkServer("http://example.com");

        assertEquals("Server is up", result);
    }

    @Test
    void testCheckServerDown() {
        NetworkClient mockClient = mock(NetworkClient.class);
        when(mockClient.isReachable("http://down.com")).thenReturn(false);

        PingService service = new PingService(mockClient);
        String result = service.checkServer("http://down.com");

        assertEquals("Server is down", result);
    }
}