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

    //add employee
    @GetMapping("/getAllEmployee")
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    //read all employee details
    @PostMapping("/saveEmployee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }

    //update employee details
    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable int id){
        return employeeService.updateEmployee(id,employeeDTO);
    }

    //delete employee
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return employeeService.deleteEmployee(id);
    }

    //get one of the employee details
    @GetMapping("/getEmployeeByID/{id}")
    public EmployeeDTO getEmployeeByID(@PathVariable String id){
        return employeeService.getEmployeeByID(id);
    }

    //get next id(API for autoincrement id)

}
