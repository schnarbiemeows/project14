package com.example.project14.user.controller;

import com.example.project14.user.model.User;
import com.example.project14.user.repository.UserRepository;
import com.example.project14.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void createUser() throws Exception {
        /*User user = new User(1,"jack","smith",
                LocalDate.of(2000,10,10));
        String input = " { \"id\" : 1 , \"firstName\" : \"jack\" ," +
                "\"lastName\" : \"smith\" , \"dob\" : \"null\" }";
        when(userService.createUser(user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated());*/
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUserById() {
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}