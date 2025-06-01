package com.example.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.example.ProductManagement.ErrorBean.CustomException;
import com.example.ProductManagement.config.JwtUtility;
import com.example.ProductManagement.model.Product;
import com.example.ProductManagement.model.Users;
import com.example.ProductManagement.repo.ProductRepo;

@RestController
@RequestMapping("/api/public")
public class Public{

    @GetMapping("/welcome")
    public ResponseEntity<Object> getMsg(){
        String name = "Welcome !!!!";
        return ResponseEntity.ok(name);
    }

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/product/search")
    public List<Product> getProduct(@RequestParam String keyword){
        if(keyword == null || keyword.isEmpty()){
            throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid keyword");
        }
        List<Product> productList =  productRepo.findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(keyword, keyword);

        return productList;
    }


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtility jwtUtility;

    @PostMapping("/login")
    public ResponseEntity<Object> getLogin(@RequestBody Users users) throws Exception{
        System.out.println("username: " + users.getUsername());
        System.out.println("password: " + users.getPassword());

        if(users.getUsername() == null || users.getPassword() == null){
            throw new CustomException(HttpStatus.BAD_REQUEST, "username or password incorrect");
        }

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    users.getUsername(),
                    users.getPassword()
            ));
            String token = jwtUtility.generateToken(users.getUsername());
            return ResponseEntity.ok(token);
        }
        catch (BadCredentialsException | UsernameNotFoundException e){
            throw new CustomException(HttpStatus.UNAUTHORIZED, "BaaadCredentialsException");
        }
    }
}

