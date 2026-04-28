package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private UserResponse customer;
    private String status;
    private double totalAmount;
    private String shippingAddress;
}
