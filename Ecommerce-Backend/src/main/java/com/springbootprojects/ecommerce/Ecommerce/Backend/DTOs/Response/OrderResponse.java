package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CustomerEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private CustomerResponse customer;
    private String status;
    private double totalAmount;
    private String shippingAddress;
}
