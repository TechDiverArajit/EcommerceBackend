package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.CustomerResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.CustomerEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    public CustomerResponse getCustomerById(Long cId) {
        CustomerEntity customer = customerRepository.findById(cId).orElse(null);
        return modelMapper.map(customer ,CustomerResponse.class);
    }
}
