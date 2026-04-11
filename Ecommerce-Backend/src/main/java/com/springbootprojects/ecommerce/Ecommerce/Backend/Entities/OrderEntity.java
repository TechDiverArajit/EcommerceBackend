package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

@Entity
public class OrderEntity extends BaseEntity {
    @Column(table = "Order_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    private String status;
    private double totalAmount;
    private String ShippingAddress;

}
