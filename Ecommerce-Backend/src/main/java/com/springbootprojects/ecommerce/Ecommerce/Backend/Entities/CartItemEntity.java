package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CartItemEntity extends BaseEntity {
    @Column(table = "CartItem_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Long quantity;
}
