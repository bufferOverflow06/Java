package com.example.spring_basics;

import java.beans.ConstructorProperties;

public class Alien {
    private Computer comp;
    private int age;

    public Alien() {
//        System.out.println("Object created");
    }

//    @ConstructorProperties({"laptop", "age"})
//    public Alien(Laptop laptop, int age) {
//        this.laptop = laptop;
//        this.age = age;
//    }


    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        System.out.println("Setter called");
        this.age = age;
    }

    public void code(){
        System.out.println("Coding");
        comp.compile();
    }

}
