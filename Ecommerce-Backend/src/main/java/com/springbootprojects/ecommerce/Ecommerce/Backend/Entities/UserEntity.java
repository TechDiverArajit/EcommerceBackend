package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Customer")
public class UserEntity extends BaseEntity implements UserDetails {

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
    @Builder.Default
    private Role role = Role.ROLE_USER;

    public String fullName(){
        return firstName + " "+lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    public enum Role{
        ROLE_USER,ROLE_ADMIN;
    }


}
