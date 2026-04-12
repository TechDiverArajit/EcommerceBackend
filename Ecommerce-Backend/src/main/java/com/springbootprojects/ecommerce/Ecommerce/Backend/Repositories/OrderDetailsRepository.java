package com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity , Long> {
}
