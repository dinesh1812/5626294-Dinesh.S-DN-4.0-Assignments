package com.example.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import com.example.user.repository.UserRepository;
import com.example.user.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Test
    void testGetUserNameById() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(new User(1L, "Alice"));

        UserService userService = new UserService(mockRepo);

        String result = userService.getUserNameById(1L);
        assertEquals("Alice", result);
    }

    @Test
    void testGetUserCount() {
        UserRepository mockRepo = mock(UserRepository.class);
        List<User> mockUsers = Arrays.asList(
            new User(1L, "A"), new User(2L, "B")
        );
        when(mockRepo.findAll()).thenReturn(mockUsers);

        UserService userService = new UserService(mockRepo);

        int count = userService.getUserCount();
        assertEquals(2, count);
    }
}
