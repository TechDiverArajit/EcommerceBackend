package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.CustomerResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/{cId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long cId){
        return ResponseEntity.ok(customerService.getCustomerById(cId));
    }





}
