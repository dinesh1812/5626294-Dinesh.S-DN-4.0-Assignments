package com.example.user.repository;

import com.example.user.model.User;
import java.util.List;

public interface UserRepository {
    User findById(Long id);
    List<User> findAll();
}
