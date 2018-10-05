package com.alok.society.employeeRegistration.repository;

import com.alok.society.employeeRegistration.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Employee findByEmpId(Long id);
}
