package com.cbfacademy.apiassessment.Service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.Model.Employee;
import com.cbfacademy.apiassessment.Repository.EmployeeRepository;

@Service
public class ListEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public ListEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee); 
    }

    @Override
    public Employee updateEmployee(UUID id, Employee updatedEmployee) {
        
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            // Update properties of existingEmployee with those of updatedEmployee
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setJobtitle(updatedEmployee.getJobTitle());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setTrainingComplete(updatedEmployee.getTrainingComplete());

            // Save update
            return employeeRepository.save(existingEmployee);
        } else {
            return null; 
        }
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteEmployee(id);
    }
}
