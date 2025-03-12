package com.example.spring_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {

    @Autowired
//    @Qualifier("laptop") // or desktop
    private Computer comp;

    @Value("23")
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
        System.out.println("Coding inside Alien class");
        comp.compile();
    }

}
