package com.tomato.backend.util;
import org.springframework.stereotype.Component;

@Component
public interface MessageUtil {
    String USER_NOT_FOUND = "User not found";
    String INVALID_CREDENTIAL = "Invalid credential";
    String USER_ALREADY_REGISTERED = "User already registered";
}
