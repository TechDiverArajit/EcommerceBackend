package com.springbootprojects.ecommerce.Ecommerce.Backend.Services;

import com.springbootprojects.ecommerce.Ecommerce.Backend.Entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    @Value("${Jwt.secretKey}")
    private String secretKey;

    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(UserEntity user){
        return Jwts.builder()
                .subject(user.getId().toString())
                .claim("Email",user.getEmail())
                .claim("roles", List.of("ADMIN","USER"))
                .claim("type","access")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*5))
                .signWith(getSecretKey())
                .compact();
    }

    public String generateRefreshToken(UserEntity user){
        return Jwts.builder()
                .subject(user.getId().toString())
                .claim("type","refresh")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L*60*60*24*30))
                .signWith(getSecretKey())
                .compact();
    }

    public Long getUserIdWithToken(String token){

        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return Long.valueOf(claims.getSubject());
    }

    public Claims extractToken(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }






}
