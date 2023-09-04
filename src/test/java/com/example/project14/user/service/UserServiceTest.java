package com.example.project14.user.service;

import com.example.project14.user.model.User;
import com.example.project14.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void getAllUsers() {
        List<User> users = Arrays.asList( new User[]{ new User(1,"jack","smith", LocalDate.now().minusYears(10)) ,
                new User(1,"jack","smith", LocalDate.now().minusYears(10)) ,
                new User(1,"jack","smith", LocalDate.now().minusYears(10))});
        when(userRepository.findAll()).thenReturn(users);
        List<User> results = userService.getAllUsers();
        assertEquals(users.size(),results.size());
        assertEquals(results.size(),3);
        assertEquals(results.get(0).getFirstName(),users.get(0).getFirstName());
    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }
}