package com.cbfacademy.apiassessment.Repository;

import java.util.UUID;

import com.cbfacademy.apiassessment.Core.Repository;
import com.cbfacademy.apiassessment.Model.Employee;

public interface EmployeeRepository extends Repository<Employee, UUID> {

   void deleteEmployee(UUID id);
}
