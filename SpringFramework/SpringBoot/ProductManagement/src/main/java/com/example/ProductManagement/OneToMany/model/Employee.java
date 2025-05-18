package com.example.ProductManagement.OneToMany.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

// One Employee has Many Laptop
@Entity
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    private String empName;

    @OneToMany(mappedBy = "employee")
    private List<Laptop> laptops;

    public Employee() {
    }

    public Employee(Integer empId, String empName, List<Laptop> laptops) {
        this.empId = empId;
        this.empName = empName;
        this.laptops = laptops;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", laptops=" + laptops + "]";
    }

}
