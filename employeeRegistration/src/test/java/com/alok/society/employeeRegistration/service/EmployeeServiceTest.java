package com.alok.society.employeeRegistration.service;

import com.alok.society.employeeRegistration.exception.InvalidMethodArgumentException;
import com.alok.society.employeeRegistration.model.Employee;
import com.alok.society.employeeRegistration.model.EmployeeDTO;
import com.alok.society.employeeRegistration.repository.EmployeeRepository;
import com.alok.society.employeeRegistration.transformer.EmployeeTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeTransformer employeeTransformer;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void testAddEmployee() throws InvalidMethodArgumentException {
        Employee emp = new Employee();
        emp.setFname("Alok");
        emp.setLname("Singh");
        emp.setGender("Male");
        emp.setDateOfBirth( new Date("11/12/1989"));
        emp.setDepartment("IT");

        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName("Alok");
        dto.setLastName("Singh");
        dto.setGender("Male");
        dto.setDob( new Date("11/12/1989"));
        dto.setDepartment("IT");
        Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
        Mockito.when(employeeTransformer.toEmployee(dto)).thenReturn(emp);
        Mockito.when(employeeTransformer.toEmployeeDTO(emp)).thenReturn(dto);
        EmployeeDTO persitedDTO = employeeService.addEmployee(dto);
        assert(persitedDTO.getFirstName()).equals(emp.getFname());
        assert(persitedDTO.getLastName()).equals(emp.getLname());
        assert(persitedDTO.getGender()).equals(emp.getGender());
        assert(persitedDTO.getDob()).equals(emp.getDateOfBirth());
        assert(persitedDTO.getDepartment()).equals(emp.getDepartment());
    }
}
