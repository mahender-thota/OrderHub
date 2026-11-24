package com.orderhub.controller;

import com.orderhub.dto.user.UserRequestDto;
import com.orderhub.dto.user.UserResponseDto;
import com.orderhub.services.UserService;

import com.orderhub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderHub/Users")
public class UsersController {

    @Autowired
    UserService service;

    // 1. Register User
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto requestDto) {

        return new ResponseEntity<>(service.registerUser(requestDto), HttpStatus.CREATED);
    }

    // 2. Get User By ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {

        return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
    }

    // 3. Get All Users
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    // 4. Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto requestDto) {
        return new ResponseEntity<>(service.updateUser(userId, requestDto), HttpStatus.OK);
    }

    // 5. Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {

        return new ResponseEntity<>(service.deleteUser(userId), HttpStatus.OK);
    }
}