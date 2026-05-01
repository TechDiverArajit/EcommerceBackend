package com.springbootprojects.ecommerce.Ecommerce.Backend.Controllers;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.AuthRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.AuthResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.UserResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Exceptions.ResourceNotFoundException;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.AuthService;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.JwtService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    @Value("${deploy.env}")
    private String deployEnv;

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
    public ResponseEntity<AuthResponse> login(@RequestBody  @Valid AuthRequest.Login login , HttpServletResponse response){
        AuthResponse authResponse = authService.login(login);
        Cookie cookie =  new Cookie("refreshToken",authResponse.getRefreshToken());
        cookie.setHttpOnly(true);
        cookie.setSecure("production".equals(deployEnv));
        response.addCookie(cookie);
        return ResponseEntity.ok(authResponse);

    }

        @PostMapping("/refresh")
        public ResponseEntity<AuthResponse> refresh(HttpServletRequest request){
            String refreshToken = Arrays.stream(request.getCookies())
                    .filter(cookie -> "refreshToken".equals(cookie.getName()))
                    .findFirst()
                    .map(cookie -> cookie.getValue())
                    .orElseThrow(() -> new ResourceNotFoundException("Cookie not found"));
            AuthResponse authResponse = authService.refresh(refreshToken);
            return ResponseEntity.ok(authResponse);
        }




}
