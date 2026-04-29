package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Request.AuthRequest;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.AuthResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.UserResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Exceptions.ResourceNotFoundException;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public UserResponse register(AuthRequest.Register register) {
        Optional<UserEntity> user = userRepository.findByEmail(register.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("Already exist: "+register.getEmail());
        }
        UserEntity user1 = modelMapper.map(register,UserEntity.class);
        user1.setPassword(passwordEncoder.encode(register.getPassword()));
        user1.setRole(UserEntity.Role.ROLE_USER);
        UserEntity savedEntity = userRepository.save(user1);
        return modelMapper.map(savedEntity,UserResponse.class);
    }

    public UserResponse getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        return modelMapper.map(user,UserResponse.class);
    }

    public AuthResponse login(AuthRequest.Login login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
        UserEntity user = (UserEntity) authentication.getPrincipal();
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        Claims claims = jwtService.extractToken(accessToken);
        return new AuthResponse(user.getId(),accessToken,refreshToken,claims.getExpiration().getTime());
    }


}
