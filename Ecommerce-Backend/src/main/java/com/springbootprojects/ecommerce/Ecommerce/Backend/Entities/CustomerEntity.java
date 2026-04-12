package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Customer")
public class CustomerEntity extends BaseEntity {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;

    @OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    private List<AddressEntity> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL , orphanRemoval = true)
    @Builder.Default
    private List<OrderEntity> orderEntityList = new ArrayList<>();

    @OneToOne(mappedBy = "Customer" , cascade = CascadeType.ALL , orphanRemoval = true)
    private CartEntity cart;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public String fullName(){
        return firstName + " "+lastName;
    }

    public enum Role{
        ROLE_USER,ROLE_ADMIN;
    }


}
