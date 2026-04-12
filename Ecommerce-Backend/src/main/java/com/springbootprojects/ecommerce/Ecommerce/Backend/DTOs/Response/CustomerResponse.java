package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.AddressEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CartEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CustomerEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.OrderEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean enabled;
    private CustomerEntity.Role role;
    private LocalDateTime createdAt;
}
