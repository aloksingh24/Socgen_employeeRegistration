package com.alok.society.employeeRegistration.controller;

import com.alok.society.employeeRegistration.exception.InvalidMethodArgumentException;
import com.alok.society.employeeRegistration.model.EmployeeDTO;
import com.alok.society.employeeRegistration.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Alok
 * Controller for adding employee
 */
@CrossOrigin()
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     *
     * @return the employee list
     */
    @ApiOperation(value = "getEmployees", notes = "Get all employees")
    @ApiResponses( value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successfully fetched the data")
    })
    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     *
     * @param emp
     * @return the emp list after persisting
     */
    @ApiOperation(value = "saveEmployee", notes = "Save the employee data")
    @PostMapping("/add")
    public EmployeeDTO addEmployee(@Valid @RequestBody EmployeeDTO emp) throws InvalidMethodArgumentException {
        return employeeService.addEmployee(emp);
    }

}
