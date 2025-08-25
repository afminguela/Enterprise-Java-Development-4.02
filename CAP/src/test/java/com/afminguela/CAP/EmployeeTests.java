package com.afminguela.CAP;

import com.afminguela.CAP.Repository.EmployeeRepository;
import com.afminguela.CAP.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static com.afminguela.CAP.enums.Department.*;
import static com.afminguela.CAP.enums.Status.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EmployeeTests {
    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private EmployeeRepository employeeRepository;

@BeforeEach

	public void contextLoads() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    Employee employee = new Employee(null,"JL",cardiology,ON_CALL);
    Employee employee2 = new Employee(null,"Laura",orthopaedic,ON);

    employeeRepository.saveAll(List.of(employee,employee2));
	}

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void store_Valid_Created() throws Exception {
        Employee employee = new Employee(null,"carlos",immunology,OFF);

        String body = objectMapper.writeValueAsString(employee);
        MvcResult mvcResult = mockMvc.perform(post("/Employees")
                .content(body)
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))

        ).andExpect(status().isOk()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("carlos"));
    }

    @Test
    void getAllEmployees() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/Employees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("JL"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Laura"));
    }

    @Test
    void getEmployeeById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/Employees/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("JL"));

    }


}






