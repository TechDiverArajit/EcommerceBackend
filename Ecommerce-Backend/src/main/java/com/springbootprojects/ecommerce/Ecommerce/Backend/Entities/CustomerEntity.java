package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class CustomerEntity extends BaseEntity {
    @Column(table = "Customer_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String address;
    @OneToMany(mappedBy = "customer")
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderEntity order;

}
