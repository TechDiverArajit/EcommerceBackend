package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


public class AuthRequest {


    @Data
    public static class Register{
        @NotBlank(message = "first name is required")
        private String firstName;
        @NotBlank(message = "last name is required")
        private String lastName;
        @NotBlank(message = "email is required")
        @Email(message = "valid email format required")
        private String email;
        @NotBlank(message = "password is required")
        @Size(min = 8 , message = "password must be 8 characters")
        private String password;
        @NotBlank(message = "phone no. is required")
        private String phone;
    }

    @Data
    public static class Login{
        @NotBlank(message = "email is required")
        @Email(message = "valid email format required")
        private String email;
        @NotBlank(message = "password is required")
        @Size(min = 8 , message = "password must be 8 characters")
        private String password;
    }

    @Data
    public static class RefreshToken{
        private String refreshToken;
    }

    @Data
    public static class updatePassword{
        @NotBlank(message = "Current password is required")
        private String currentPassword;
        @NotBlank(message = "New password required")
        @Size(min = 8,message = "length must be minimum 8")
        private String newPassword;
    }


}
