package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;

@Entity
public class PaymentEntity extends BaseEntity {



    private String transactionID;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private String status;

    private String method;

    private Double amount;
}
