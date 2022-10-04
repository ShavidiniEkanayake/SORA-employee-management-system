package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/employee")
@CrossOrigin
public class employeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployee")
    public String getEmployee(){
        return "Root";
    }

    @PostMapping("/saveEmployee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }
}
