package com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity , Long> {
}
