package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;

@Data
public class CartItemResponse {
    private Long id;
    private CartResponse cart;
    private ProductResponse product;
    private Long quantity;
}
