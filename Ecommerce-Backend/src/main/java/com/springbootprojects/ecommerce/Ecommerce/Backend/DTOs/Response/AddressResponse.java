package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.AddressEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private Boolean isDefault;
    private AddressEntity.AddressType type;
}
