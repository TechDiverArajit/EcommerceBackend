package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Payment")
public class PaymentEntity extends BaseEntity {



    private String transactionID;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private String status;

    private String method;

    private Double amount;
}
