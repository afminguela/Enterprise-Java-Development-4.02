package com.afminguela.CAP.controller;

import com.afminguela.CAP.Repository.EmployeeRepository;
import com.afminguela.CAP.enums.Department;
import com.afminguela.CAP.enums.Status;
import com.afminguela.CAP.models.Employee;
import com.afminguela.CAP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping
    public List<Employee> findAll() {

        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/status/{status}")
    public List<Employee> findByStatus(@PathVariable Status status){
        return employeeService.findEmployeeByStatus(status);
    }

    @GetMapping("/search/department/{department}")
    public List<Employee> findBydepartment(@PathVariable Department department){
        return employeeService.findAllEmployeesByDepartment(department);
    }


}
