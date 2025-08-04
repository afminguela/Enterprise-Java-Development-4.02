package com.afminguela.CAP.controller;

import com.afminguela.CAP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employees")
public class PatientController {
    @Autowired
    private EmployeeService employeeService;
}
