package com.khasanovtr.employeewebapplication.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String name;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(String name, String lastName) {
        Random random = new Random();
        this.name = name;
        this.lastName = lastName;
        this.salary = random.nextInt(500000) + 1000;
        this.departmentId = random.nextInt(5) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

    @Override
    public String toString() {
        return "Сотрудник " + "name= " + name + '\'' + ", lastName= " + lastName;
    }
}
