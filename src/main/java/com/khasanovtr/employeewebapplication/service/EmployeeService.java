package com.khasanovtr.employeewebapplication.service;

import com.khasanovtr.employeewebapplication.model.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
    public Employee add(String name, String lastName);
    public Employee remove(String name,String lastName);
    public Employee find (String name,String lastName);
    public Collection <Employee> findAll();

}
