package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PaymentEntity extends BaseEntity {
    @Column(name = "payment_id")
    private Long id;

    private String status;

    private String method;

    private Double amount;
}
