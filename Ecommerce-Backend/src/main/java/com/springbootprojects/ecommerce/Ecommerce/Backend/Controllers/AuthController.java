package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.AuthRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.AuthResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.UserResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid AuthRequest.Register register){
        UserResponse userResponse = authService.register(register);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(authService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody  @Valid AuthRequest.Login login ){
        AuthResponse authResponse = authService.login(login);
        return ResponseEntity.ok(authResponse);

    }



}
