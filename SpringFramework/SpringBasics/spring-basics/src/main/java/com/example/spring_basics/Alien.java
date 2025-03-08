package com.example.spring_basics;

public class Alien {
    private int age;

    public Alien() {
        System.out.println("Object created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    public void code(){
        System.out.println("Coding");
    }
}
