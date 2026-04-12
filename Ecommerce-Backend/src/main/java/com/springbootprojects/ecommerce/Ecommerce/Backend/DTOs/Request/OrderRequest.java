package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import lombok.Data;

@Data
public class OrderRequest {
    private Long customerId;
    private String status;
    private double totalAmount;
    private String shippingAddress;

}
