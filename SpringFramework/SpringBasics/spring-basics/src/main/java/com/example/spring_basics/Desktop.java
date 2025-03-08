package com.example.spring_basics;

public class Desktop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}
