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
@Table(name = "Orders")
public class OrderEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity customer;
    private String status;
    private double totalAmount;
    private String shippingAddress;

}
