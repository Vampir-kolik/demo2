package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/emp")
public class EmployeeControler {
    
    @Autowired
    EmployeeRepo employeRepo;

    // http://localhost:8080
    @PostMapping("/add")
    Employee addEmployee(@RequestBody Employee employee) {

        employeRepo.save(employee);
        return employee;
    }

    @RequestMapping(value = "add2")
    Employee addEmployee2(@RequestParam String name) {
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName(name);

        employeRepo.save(employee2);
        return employee2;
    }

    @GetMapping("/getAll")
    List<Employee> getEmployee() {

        List<Employee> employee = employeRepo.findAll();
        return employee;
    }
    
}
