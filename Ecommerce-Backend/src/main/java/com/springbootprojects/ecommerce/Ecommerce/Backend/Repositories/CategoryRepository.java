package com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

}
