package com.example.basicAuthentication.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil{

    private final long EXPIRATION_TIME = 1000*60*60;

    private final String SECRET = "my-super-secret-key-that-is-long-enough-123456789!@#";
    private final SecretKey key  = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username){
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact(); // compact method will convert all these into single String
    }
}
