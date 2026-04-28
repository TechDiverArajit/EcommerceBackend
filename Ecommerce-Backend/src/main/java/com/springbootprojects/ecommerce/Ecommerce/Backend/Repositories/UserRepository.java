package com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}
