package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

@Entity
public class CartEntity extends BaseEntity{

    @Column(table = "cart_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "cart_customer_id")
    private CustomerEntity CustomerID;

    private Boolean status;
}
