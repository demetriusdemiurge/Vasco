package com.demetriusdemiurge.vasco.service.profile;

import com.demetriusdemiurge.vasco.entity.User;
import com.demetriusdemiurge.vasco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
} 