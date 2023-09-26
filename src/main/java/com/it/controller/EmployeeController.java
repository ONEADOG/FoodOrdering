package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.EmployeeEntity;
import com.it.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {

    @Autowired 
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeEntity> listEmployee() {
        return employeeService.listEmployees();
    }

    @GetMapping("/employees/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public EmployeeEntity save(@RequestBody EmployeeEntity request) {
        return employeeService.save(request);
    }
    
    @PutMapping("/employees/{id}")
    public EmployeeEntity update(@RequestBody EmployeeEntity request, @PathVariable Integer id) {
        return employeeService.update(request, id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }
    
}
