package com.cbfacademy.apiassessment.Service;

import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.Model.Employee;

public interface EmployeeService {


    List<Employee> getAllEmployees();


    Employee getEmployeeById(UUID id);

  
    Employee createEmployee(Employee employee);

 
    Employee updateEmployee(UUID id, Employee updatedEmployee);


    void deleteEmployee(UUID id);
    
}
