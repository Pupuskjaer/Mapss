package com.khasanovtr.employeewebapplication.service;

import com.khasanovtr.employeewebapplication.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalary(int departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<Employee> allEmployees(int departmentId) {
        return employeeService.findAll().stream().filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployees() {
        return employeeService.findAll().stream().collect(groupingBy(Employee::getDepartmentId));
    }
}
