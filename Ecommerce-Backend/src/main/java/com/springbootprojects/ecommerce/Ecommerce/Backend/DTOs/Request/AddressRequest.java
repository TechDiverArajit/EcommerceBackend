package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.AddressEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressRequest {

    @NotBlank(message = "please enter your name")
    @Size(min = 6,message = "please enter your full name")
    private String fullName;

    @Size(min = 10,message = "Enter valid Phone number")
    @NotBlank(message = "phone number is required")
    private String phone;


    @NotBlank(message = "Address line 1 is required")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Postal Code required")
    private String postalCode;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "country is required")
    private String country;

    private Boolean isDefault = false;

    @NotNull(message = "address type is required")
    private AddressEntity.AddressType type;
}
