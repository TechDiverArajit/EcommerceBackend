package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

@Entity
public class CartEntity extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity Customer;

    private String status;
}
