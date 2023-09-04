package com.example.project14.user.service;

import com.example.project14.user.model.User;
import com.example.project14.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User createUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
