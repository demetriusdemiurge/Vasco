package com.emperror1917.vasco.service;

import com.emperror1917.vasco.entity.User;
import java.util.List;

public interface UserService {

    User getUserById(Long id);
    List<User> getAllUsers();

    User saveUser(User user);

    void deleteUser(Long id);
} 