package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Employee {

    private String email;

    private String name;

    private double salary;

List<Emp_Departments> empDepartments;

List<Emp_Location>  empLocationList;

List<Emp_Benefits>  empBenefits;


//    public Employee() {
//    }

    public Employee(String email, String name, double salary, List<Emp_Departments> empDepartments, List<Emp_Location> empLocationList, List<Emp_Benefits> empBenefits) {
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.empDepartments = empDepartments;
        this.empLocationList = empLocationList;
        this.empBenefits = empBenefits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Emp_Departments> getEmpDepartments() {
        return empDepartments;
    }

    public void setEmpDepartments(List<Emp_Departments> empDepartments) {
        this.empDepartments = empDepartments;
    }

    public List<Emp_Location> getEmpLocationList() {
        return empLocationList;
    }

    public void setEmpLocationList(List<Emp_Location> empLocationList) {
        this.empLocationList = empLocationList;
    }

    public List<Emp_Benefits> getEmpBenefits() {
        return empBenefits;
    }

    public void setEmpBenefits(List<Emp_Benefits> empBenefits) {
        this.empBenefits = empBenefits;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", empDepartments=" + empDepartments +
                ", empLocationList=" + empLocationList +
                ", empBenefits=" + empBenefits +
                '}';
    }
}

