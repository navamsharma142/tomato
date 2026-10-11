package com.tomato.backend.exception;

import java.time.Instant;
import java.util.Map;


public record ApiErrorResponse (
    Instant timestamp, // Records when the error happened.
    int status, // Contains the HTTP status code associated with the error.
    String error, // Provides a short description of the HTTP error category.
    String message, // Contains a more specific explanation of what went wrong.
    String path, // Contains the API URL/path that caused the error.
    String code, // This is an application-specific error code.
    Map<String, String> validationErrors // Contains validation errors associated with individual fields.
){}
