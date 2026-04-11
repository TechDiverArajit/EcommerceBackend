package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

@Entity
public class ProductEntity extends BaseEntity {
    @Column(table = "product_id")
    private Long productId;
    private String productTitle;
    private String brand;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
