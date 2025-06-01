package com.example.ProductManagement.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ProductManagement.utilities.Utility;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtility jwtUtility;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(Utility.JWT_TOKEN_STRING);
        String token = null;
        if(authHeader != null && !authHeader.trim().isEmpty() && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);

            if(SecurityContextHolder.getContext().getAuthentication() == null){
                try{
                    UserDetails userDetails = jwtUtility.getUser(token);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities()); // important donot miss userDetails.getAuthorities()
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
