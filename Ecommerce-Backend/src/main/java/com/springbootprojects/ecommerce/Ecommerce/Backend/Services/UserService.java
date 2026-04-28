package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.UserResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Exceptions.ResourceNotFoundException;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserResponse getCustomerById(Long cId) {
        UserEntity user = userRepository.findById(cId).orElse(null);
        return modelMapper.map(user , UserResponse.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("not found"));
    }
}
