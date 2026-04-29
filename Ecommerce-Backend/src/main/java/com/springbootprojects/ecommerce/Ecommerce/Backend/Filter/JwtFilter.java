package com.springbootprojects.ecommerce.Ecommerce.Backend.Filter;

import com.springbootprojects.ecommerce.Ecommerce.Backend.DTOs.Response.UserResponse;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.AuthService;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.JwtService;
import com.springbootprojects.ecommerce.Ecommerce.Backend.Services.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.management.RuntimeErrorException;
import java.io.IOException;
import java.security.InvalidKeyException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info(request.getRequestURI());
        String path = request.getRequestURI();
        final String requestHeader = request.getHeader("Authorization");

        if(requestHeader==null || !requestHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = requestHeader.split("Bearer ")[1];

        Claims claims = jwtService.extractToken(token);
        String tokenType = claims.get("type",String.class);
        if(path.equals("/auth/refresh")){
            if(!tokenType.equals("refresh")){
                throw new RuntimeException("refresh token needed");
            }
        }else{
            if(!tokenType.equals("access")){
                throw new RuntimeException("access token required");
            }
        }


        Long userId = jwtService.getUserIdWithToken(token);

        if(userId!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserResponse userResponse = userService.getCustomerById(userId);
            UserEntity userEntity = modelMapper.map(userResponse,UserEntity.class);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userEntity,null,userEntity.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);



    }
}
