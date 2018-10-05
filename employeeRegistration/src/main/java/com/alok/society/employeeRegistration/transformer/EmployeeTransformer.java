package com.alok.society.employeeRegistration.transformer;

import com.alok.society.employeeRegistration.exception.InvalidMethodArgumentException;
import com.alok.society.employeeRegistration.model.Employee;
import com.alok.society.employeeRegistration.model.EmployeeDTO;
import org.springframework.stereotype.Component;


/**
 * Created by Alok
 * Util class to convert the employee to DTO and via-versa
 */
@Component
public class EmployeeTransformer {
    /**
     * Convert the employeeDTO to employee
     * @param employeeDTO
     * @return The Employee
     */
    public Employee toEmployee(EmployeeDTO employeeDTO) throws InvalidMethodArgumentException {
        Employee emp = new Employee();

        if(employeeDTO.getFirstName() !=null && employeeDTO.getLastName() !=null && employeeDTO.getGender() != null
                && employeeDTO.getDob() != null && employeeDTO.getDepartment() != null){
            emp.setFname(employeeDTO.getFirstName());
            emp.setLname(employeeDTO.getLastName());
            emp.setGender(employeeDTO.getGender());
            emp.setDateOfBirth(employeeDTO.getDob());
            emp.setDepartment(employeeDTO.getDepartment());
        }else {
            throw new InvalidMethodArgumentException("Invalid ");
        }

        return emp;
    }

    /**
     * Convert the employee to employeeDTO
     * @param employee
     * @return employeeDTO
     */
    public EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstName(employee.getFname());
        employeeDTO.setLastName(employee.getLname());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setDob(employee.getDateOfBirth());
        employeeDTO.setDepartment(employee.getDepartment());

        return employeeDTO;
    }
}
