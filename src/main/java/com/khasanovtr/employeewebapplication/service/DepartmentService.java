package com.khasanovtr.employeewebapplication.service;

import com.khasanovtr.employeewebapplication.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Employee minSalary(int departmentId);

    public Employee maxSalary(int departmentId);
    public Collection<Employee> allEmployees(int departmentId);
    public Map<Integer, List<Employee>> allEmployees();
}
