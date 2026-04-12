package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
}
