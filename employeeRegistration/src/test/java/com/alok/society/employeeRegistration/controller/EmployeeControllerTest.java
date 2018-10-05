package com.alok.society.employeeRegistration.controller;

import com.alok.society.employeeRegistration.EmployeeRegistrationApplicationTests;
import com.alok.society.employeeRegistration.model.EmployeeDTO;
import com.alok.society.employeeRegistration.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class EmployeeControllerTest extends EmployeeRegistrationApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private EmployeeService employeeService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testEmp() throws Exception {
        mockMvc.perform(get("/api/employee/all")).andExpect(status().isOk());
    }

    @Test
    public void testAddEmployee() throws Exception {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName("Alok");
        dto.setLastName("Singh");
        dto.setGender("Male");
        dto.setDob( new Date("11/12/1989"));
        dto.setDepartment("IT");

        String testJson = this.mapToJson(dto);
        Mockito.when(employeeService.addEmployee(Mockito.any(EmployeeDTO.class))).thenReturn(dto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/employee/add")
                .accept(MediaType.APPLICATION_JSON).content(testJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        JSONObject jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());

        assert(jsonObject.get("firstName").toString()).equals("Alok");
        assert(jsonObject.get("lastName").toString()).equals("Singh");
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.writeValueAsString(obj);
    }
}
