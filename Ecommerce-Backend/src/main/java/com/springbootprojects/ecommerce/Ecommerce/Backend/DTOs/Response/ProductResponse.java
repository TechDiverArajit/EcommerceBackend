package com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private Integer stocks;
    private String description;
    private CategoryResponse category;
}
