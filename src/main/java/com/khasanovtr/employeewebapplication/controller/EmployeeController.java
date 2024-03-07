package com.khasanovtr.employeewebapplication.controller;

import com.khasanovtr.employeewebapplication.model.Employee;
import com.khasanovtr.employeewebapplication.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("add")
    public Employee add(@RequestParam String name,@RequestParam String lastName) {
        return employeeServiceImpl.add(name, lastName);
    }
    @GetMapping("remove")
    public Employee remove(@RequestParam String name,@RequestParam String lastName) {
        return employeeServiceImpl.remove(name, lastName);
    }
    @GetMapping("find")
    public Employee find(@RequestParam String name,@RequestParam String lastName) {
        return employeeServiceImpl.find(name, lastName);
    }
    @GetMapping("findAll")
    public Collection<Employee> findAll() {
        return employeeServiceImpl.findAll();
    }
}
