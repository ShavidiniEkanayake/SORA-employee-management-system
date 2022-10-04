package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/employee")
@CrossOrigin
public class employeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/saveEmployee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id){
        return employeeService.updateEmployee(id,employeeDTO);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/getEmployeeByUserId/{id}")
    public EmployeeDTO getUserByUserID(@PathVariable String id){
        return employeeService.getEmployeeByUserID(id);
    }

}
