package com.alok.society.employeeRegistration.service;

import com.alok.society.employeeRegistration.exception.InvalidMethodArgumentException;
import com.alok.society.employeeRegistration.model.EmployeeDTO;
import com.alok.society.employeeRegistration.repository.EmployeeRepository;
import com.alok.society.employeeRegistration.transformer.EmployeeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alok
 * business logic for employee entitiy
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeTransformer employeeTransformer;

    public List<EmployeeDTO>  getAllEmployees(){
        return getAllData();
    }
    public EmployeeDTO addEmployee(EmployeeDTO emp) throws InvalidMethodArgumentException {
        return employeeTransformer.toEmployeeDTO( employeeRepository.save(employeeTransformer.toEmployee(emp)));
    }

    public List<EmployeeDTO> getAllData(){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            employeeDTOS.add(employeeTransformer.toEmployeeDTO(employee));
        });
        return employeeDTOS;
    }
}
