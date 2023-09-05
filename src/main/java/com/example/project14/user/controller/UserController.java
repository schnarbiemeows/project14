package com.example.project14.user.controller;

import com.example.project14.user.exceptions.UserNotFoundException;
import com.example.project14.user.model.User;
import com.example.project14.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() throws InterruptedException {
        int min = 1000;
        int max = 7000;
        int timeDelay = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println("sleeping for " + timeDelay + " seconds");
        TimeUnit.MILLISECONDS.sleep(timeDelay);
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if(user==null) {
            throw new UserNotFoundException("ID : " + id + " was not found");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User data) {
        data = userService.createUser(data);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(data.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User data) {
        userService.updateUser(data);
        return new ResponseEntity<User>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.GONE);
    }
}
