package com.afminguela.CAP.service;

import com.afminguela.CAP.Repository.EmployeeRepository;
import com.afminguela.CAP.Repository.PatientRepository;
import com.afminguela.CAP.enums.Department;
import com.afminguela.CAP.enums.Status;
import com.afminguela.CAP.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> findAllEmployeesByDepartment(Department department){
        return employeeRepository.findEmployeesByDepartment(department);
    }

    public List<Employee> findEmployeeByStatus(Status status){
        return employeeRepository.findByStatus(status);
    }



}
