package com.example.ProductManagement.OneToOne.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id", referencedColumnName = "laptopId")
    private Laptop laptop;

    public Employee() {
    }

    public Employee(Long empId, String name, Laptop laptop) {
        this.empId = empId;
        this.name = name;
        this.laptop = laptop;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
