package com.example.spring_basics;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    public Desktop(){
        System.out.println("Desktop ojbect created");
    }


    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}
