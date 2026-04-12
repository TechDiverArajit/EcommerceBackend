package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.OrderEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class OrderDetailsRequest {

    private Long orderId;
    private Long productId;
    private Long quantity;
    private Double unitPrice;
}
