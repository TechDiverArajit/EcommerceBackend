package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;

@Data
public class CartResponse {
    private Long id;
    private UserResponse customer;
    private String status;
}
