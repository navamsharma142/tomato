package com.tomato.backend.service;

import com.tomato.backend.dto.request.UserLoginRequest;
import com.tomato.backend.dto.request.UserRegisterRequest;
import com.tomato.backend.dto.response.UserResponse;
import com.tomato.backend.entity.User;
import com.tomato.backend.exception.InvalidCredentialException;
import com.tomato.backend.exception.UserAlreadyRegisteredException;
import com.tomato.backend.exception.ResourceNotFoundException;
import com.tomato.backend.mapper.UserMapper;
import com.tomato.backend.repository.UserRepository;
import com.tomato.backend.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserResponse register(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyRegisteredException(MessageUtil.USER_ALREADY_REGISTERED);
        }

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponse login(UserLoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException(MessageUtil.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialException(MessageUtil.INVALID_CREDENTIAL);
        }

        return userMapper.toDto(user);
    }
}
