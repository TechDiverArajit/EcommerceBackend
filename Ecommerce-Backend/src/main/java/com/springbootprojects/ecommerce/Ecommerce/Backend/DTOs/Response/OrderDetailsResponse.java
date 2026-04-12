package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;

@Data
public class OrderDetailsResponse {

    private Long id;
    private OrderResponse order;
    private ProductResponse product;
    private Long quantity;
    private Double unitPrice;

}
