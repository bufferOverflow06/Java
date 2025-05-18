package com.example.ProductManagement.OneToMany.model;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer laptopId;

    private String brand;

    // I can't have mappedBy = "laptops" here because doing this would mean that Employee is our owing side
    // and FK will be created there
    // also there would be inconsistency if we try to add data into laptop
    // as employee table would have duplicate values and `unique index of primary key violation` error occurs
    // So we let the `Laptop` table be the owning side and create empId FK in it
    @ManyToOne(cascade = CascadeType.ALL) // saving laptop should automatically save employee in employee table
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private Employee employee;

    public Laptop() {
    }

    public Laptop(Integer laptopId, String brand, Employee employee) {
        this.laptopId = laptopId;
        this.brand = brand;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Laptop [laptopId=" + laptopId + ", brand=" + brand + ", employee=" + employee + "]";
    }

    public Integer getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Integer laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
