package com.orderhub.services;

import com.orderhub.builder.UserBuilder;
import com.orderhub.dto.user.UserRequestDto;
import com.orderhub.dto.user.UserResponseDto;
import com.orderhub.execption.UserNotFoundException;
import com.orderhub.model.Users;
import com.orderhub.repository.UsersRepository;

import com.orderhub.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UsersRepository repository;

    @Autowired
    PasswordEncoder encoder;

    // 1. Register User
    public UserResponseDto registerUser(UserRequestDto requestDto) {

        Users user = UserBuilder.buildUserFromUserRequestDTO(requestDto);
        String encoded = encoder.encode(requestDto.getPassword());
        user.setPassword(encoded);

        Users savedUser = repository.save(user);

        return UserBuilder.buildUserResponseDTOFromUser(savedUser);
    }

    // 2. Get User By ID
    public UserResponseDto getUserById(Long userId) {

        Users user = repository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(
                                        "User not found with ID: " + userId));

        return UserBuilder.buildUserResponseDTOFromUser(user);
    }

    // 3. Get All Users
    public List<UserResponseDto> getAllUsers() {

        List<Users> users = repository.findAll();
        List<UserResponseDto> responseList = new ArrayList<>();

        for (Users user : users) {
            UserResponseDto response = UserBuilder.buildUserResponseDTOFromUser(user);
            responseList.add(response);
        }

        return responseList;
    }

    // 4. Update User
    public UserResponseDto updateUser(Long userId, UserRequestDto requestDto) {

        Users user = repository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(
                                        "User not found with ID: " + userId));

        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());

        Users updatedUser = repository.save(user);

        return UserBuilder.buildUserResponseDTOFromUser(updatedUser);
    }

    // 5. Delete User
    public String deleteUser(Long userId) {

        Users user = repository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(
                                        "User not found with ID: " + userId));
        repository.delete(user);
        return "User deleted successfully with ID: " + userId;
    }
}