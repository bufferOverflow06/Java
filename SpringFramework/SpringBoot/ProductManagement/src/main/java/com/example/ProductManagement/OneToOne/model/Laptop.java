package com.example.ProductManagement.OneToOne.model;

import jakarta.persistence.*;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long laptopId;

    private String laptopName;

    @OneToOne(mappedBy = "laptop")
    private Employee employee;

    public Laptop() {
    }

    public Laptop(Long laptopId, String laptopName, Employee employee) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.employee = employee;
    }

    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", laptopName='" + laptopName + '\'' +
                ", employee=" + employee +
                '}';
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
