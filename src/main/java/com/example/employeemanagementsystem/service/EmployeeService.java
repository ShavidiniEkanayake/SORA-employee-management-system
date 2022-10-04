package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repo.EmployeeRepo;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    private  List<Employee>employeeList= new ArrayList<>();
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
        return employeeDTO;
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee>employeeList= employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    public void updateEmployee(int id,EmployeeDTO employeeDTO){

    }

    public String deleteEmployee(int id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()) {
            employeeRepo.delete(employee.get());
            return "Employee is deleted with id "+id;
        }else {
            throw new RuntimeException("Employee not found for the id "+id);
        }
//        Employee employeeById = employeeRepo.getEmployeeById(id);
//        employeeRepo.delete(modelMapper.map(employeeById,Employee.class));
//        employeeList = employeeList.stream().filter(employeeDTO-> employeeDTO.getId()!=id).
//                collect(Collectors.toList());
    }
}
