package com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity,Long> {
}
