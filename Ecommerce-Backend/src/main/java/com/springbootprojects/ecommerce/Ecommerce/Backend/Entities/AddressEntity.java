package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Addresses")
@Builder
public class AddressEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id" , nullable = false)
    private CustomerEntity customer;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String addressLine1;

    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Builder.Default
    private Boolean isDefault = false;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private AddressType type = AddressType.SHIPPING;

    public enum AddressType{
        SHIPPING , BILLING , BOTH;
    }



}
