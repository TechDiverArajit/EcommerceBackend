package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean enabled;
    private UserEntity.Role role;
    private LocalDateTime createdAt;


}
