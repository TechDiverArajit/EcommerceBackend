package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.BaseEntity;
import jakarta.persistence.Column;

public class ProductDTO {
        private Long productId;
        private String productTitle;
        private String brand;
        private Integer price;

}
