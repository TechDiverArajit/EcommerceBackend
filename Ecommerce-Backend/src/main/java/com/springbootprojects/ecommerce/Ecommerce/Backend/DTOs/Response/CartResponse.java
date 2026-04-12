package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CustomerEntity;
import lombok.Data;

@Data
public class CartResponse {
    private Long id;
    private CustomerResponse customer;
    private String status;
}
