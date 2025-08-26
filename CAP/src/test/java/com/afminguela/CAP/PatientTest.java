package com.afminguela.CAP;


import com.afminguela.CAP.Repository.EmployeeRepository;
import com.afminguela.CAP.Repository.PatientRepository;
import com.afminguela.CAP.model.Employee;
import com.afminguela.CAP.model.Patient;
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

import java.time.LocalDate;
import java.util.List;

import static com.afminguela.CAP.enums.Department.*;
import static com.afminguela.CAP.enums.Status.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PatientTest {
    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private PatientRepository patientRepository;

    private Long patientId;


    @BeforeEach
    public void contextLoads() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Patient patient = new Patient(null, "JL", LocalDate.of(2012, 12, 12), new Employee(1L, "Carlos", cardiology, ON));
        patient = patientRepository.save(patient);
        patientId = patient.getId();

        Patient patient2 = new Patient(null, "Laura", LocalDate.of(2015, 5, 20), new Employee(1L, "Carlos", cardiology, ON));
        patientRepository.save(patient2);

    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
    }
}
