package com.example.ProductManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ProductManagement.model.Users;
import com.example.ProductManagement.repo.UserRepo;

@Service
public class UserAuthServices implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(username);

         if(users == null){
             throw new UsernameNotFoundException("Invalid Username please try with correct username");
            // throw new CustomException("Invalid username please try with correct username");

         }
         else{
             BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

             users.setPassword(encoder.encode(users.getPassword()));
             return users;
         }
    }
}
