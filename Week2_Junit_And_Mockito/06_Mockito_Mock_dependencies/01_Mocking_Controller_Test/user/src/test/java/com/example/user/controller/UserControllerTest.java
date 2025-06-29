package com.example.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.user.model.User;
import com.example.user.service.UserService;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetUserById_ReturnsUser() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User(userId, "John Doe");

        when(userService.getUserById(userId)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> response = userController.getUser(userId);

        // Assert
        assertEquals("John Doe", response.getBody().getName());
        assertEquals(userId, response.getBody().getId());
    }
}