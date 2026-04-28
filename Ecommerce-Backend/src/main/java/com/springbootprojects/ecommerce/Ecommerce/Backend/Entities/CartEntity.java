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
@Table(name = "Cart")
public class CartEntity extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "customer_id")
    private UserEntity Customer;
    private String status;
}
