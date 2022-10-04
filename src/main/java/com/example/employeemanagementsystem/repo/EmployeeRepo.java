package com.example.employeemanagementsystem.repo;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

//    @Query(value = "DELETE FROM Employee WHERE id=?",nativeQuery = true)
//    Employee getEmployeeById(int employeeId);
}
