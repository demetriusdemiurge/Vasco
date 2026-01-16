package com.demetriusdemiurge.vasco.service.profile;

import com.demetriusdemiurge.vasco.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    User saveUser(User user);

    void deleteUser(Long id);
} 