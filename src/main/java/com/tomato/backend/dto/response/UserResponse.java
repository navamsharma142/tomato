package com.tomato.backend.dto.response;

import com.tomato.backend.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private UserRole userRole;
    private boolean isVerified;
    private String token;
}
