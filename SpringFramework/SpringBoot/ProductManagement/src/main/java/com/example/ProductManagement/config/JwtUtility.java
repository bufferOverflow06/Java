package com.example.ProductManagement.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.ProductManagement.ErrorBean.CustomException;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtility {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.token.validity}")
    private Long jwtTokenValidity;

    private SecretKey getKey(){
        byte[] byteArr = Decoders.BASE64.decode(secretKey);
        if(byteArr.length < 32){
            throw new IllegalArgumentException("Key size must be greater than 32");
        }
        return Keys.hmacShaKeyFor(byteArr);
    }


    public String generateToken(String username){
        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // extractSubject
    // extractExpiration
    // extractAllClaims
    // getUser
    // validateToken
    //
    public Claims extractAllClaims(final String token){
        return Jwts.parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public String extractSubject(final String token){
        Claims claims = extractAllClaims(token);
        String username = claims.getSubject();
        return username;
    }

    public Date extractExpiration(final String token){
        Claims claims = extractAllClaims(token);
        Date expirationDate = claims.getExpiration();
        return expirationDate;
    }


    @Autowired
    UserDetailsService userDetailsService;

    public UserDetails getUser(final String token){
        String username = extractSubject(token);
        return userDetailsService.loadUserByUsername(username);
    }

    public boolean validateToken(final String token, UserDetails userDetails){

        String subject = extractSubject(token);

        if(userDetails.getUsername() != subject && userDetails.getUsername().trim().isEmpty() && subject.trim().isEmpty()){
            throw new CustomException("Invalid user form jwt util");
        }
        else{
            Date date = extractExpiration(token);
            if(date.before(new Date())){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
