package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.UserResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CustomerController {

    private final UserService userService;
    @GetMapping("/{cId}")
    public ResponseEntity<UserResponse> getCustomerById(@PathVariable Long cId){
        return ResponseEntity.ok(userService.getCustomerById(cId));
    }





}
