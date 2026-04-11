package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ProductEntity extends BaseEntity {

    private String name;
    private String brand;
    private Double price;
    private Integer stocks;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
