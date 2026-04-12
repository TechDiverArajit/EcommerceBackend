package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CustomerEntity;
import lombok.Data;

@Data
public class CartRequest {
    private Long CustomerId;
    private String status;
}
