package com.orderhub.builder;

import com.orderhub.dto.user.UserRequestDto;
import com.orderhub.dto.user.UserResponseDto;
import com.orderhub.model.Users;

public class UserBuilder {

    // Request DTO to Entity
    public static Users buildUserFromUserRequestDTO(UserRequestDto requestDto) {

        return Users.builder()
                .username(requestDto.getUsername())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();
    }

    // Entity to Response DTO
    public static UserResponseDto buildUserResponseDTOFromUser(Users user) {

        return UserResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}