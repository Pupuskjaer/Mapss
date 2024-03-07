package com.khasanovtr.employeewebapplication.service;

import com.khasanovtr.employeewebapplication.exception.EmployeeAlreadyAddedException;
import com.khasanovtr.employeewebapplication.exception.EmployeeNotFoundException;
import com.khasanovtr.employeewebapplication.exception.EmployeeStorageIsFullException;
import com.khasanovtr.employeewebapplication.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int MAX = 5;
    private static final Map<String, Employee> employees = new HashMap<>();
    private Object EmployeeNotFoundException;

    public Employee add(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employees.size() == MAX) {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в списке");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Нет такого сотрудника");
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Нет такого сотрудника");
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }




}
