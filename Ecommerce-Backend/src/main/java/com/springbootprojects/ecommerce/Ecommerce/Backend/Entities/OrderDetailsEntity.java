package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

@Entity
public class OrderDetailsEntity extends BaseEntity {
    @Column(name = "Order_details_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Long quantity;
    private Double unitPrice;
}
