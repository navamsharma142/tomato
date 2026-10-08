package com.tomato.backend.mapper;

import com.tomato.backend.dto.request.UserRegisterRequest;
import com.tomato.backend.dto.response.UserResponse;
import com.tomato.backend.entity.User;

public class UserMapper {
    public User toEntity(UserRegisterRequest request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public UserResponse toDto(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
    }
}
