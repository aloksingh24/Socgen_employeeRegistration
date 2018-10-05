package com.alok.society.employeeRegistration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Alok
 * Entity to save to DB
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long empId;

    @Column(name = "employee_firstName")
    @NotNull(message = "Employee first name can not be null")
    private String fname;

    @Column(name = "employee_lastName")
    @NotNull(message = "Employee last name can not be null")
    private String lname;

    @Column(name = "employee_gender")
    @NotNull(message = "Employee gender can not be null")
    private String gender;

    @Column(name = "employee_dob")
    @NotNull(message = "Employee date of birth can not be null")
    private Date dateOfBirth;

    @Column(name = "employee_department")
    @NotNull(message = "Employee department can not be null")
    private String department;

    public Employee() {
    }

    public long getId() {
        return empId;
    }

    public void setId(long id) {
        this.empId = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
