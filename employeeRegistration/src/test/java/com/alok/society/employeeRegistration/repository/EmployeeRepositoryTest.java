package com.alok.society.employeeRegistration.repository;

import com.alok.society.employeeRegistration.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void saveEmployee(){
        Employee emp = new Employee();
        emp.setFname("Alok");
        emp.setLname("Singh");
        emp.setGender("Male");
        emp.setDateOfBirth( new Date("11/12/1989"));
        emp.setDepartment("IT");
        Employee persistedEmp = testEntityManager.persist(emp);
        Employee fromDB = employeeRepository.findByEmpId(persistedEmp.getId());
        assert(fromDB).equals(persistedEmp);
    }
}
