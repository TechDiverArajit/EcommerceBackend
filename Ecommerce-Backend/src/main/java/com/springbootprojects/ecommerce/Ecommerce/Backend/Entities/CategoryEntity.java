package com.springbootprojects.ecommerce.Ecommerce.Backend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CategoryEntity extends BaseEntity {

    @Column(table = "category_id")
    private Long id;
    private String categoryName;

}
