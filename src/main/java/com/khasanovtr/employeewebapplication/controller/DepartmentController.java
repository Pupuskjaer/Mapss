package com.khasanovtr.employeewebapplication.controller;

import com.khasanovtr.employeewebapplication.model.Employee;
import com.khasanovtr.employeewebapplication.service.DepartmentService;
import com.khasanovtr.employeewebapplication.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController  {
    private final DepartmentServiceImpl departmentService;


    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping(value = "all",params = {"departmentId"})
    public Collection<Employee> findEmployeeByDep(int departmentId) {
        return departmentService.allEmployees(departmentId);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> allEmployees() {
        return departmentService.allEmployees();
    }
}
