package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CartEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.ProductEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CartItemRequest {

    private Long cartId;
    private Long productId;
    private Long quantity;
}
