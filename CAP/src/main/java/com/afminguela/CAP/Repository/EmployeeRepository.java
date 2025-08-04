package com.afminguela.CAP.Repository;

import com.afminguela.CAP.enums.Department;
import com.afminguela.CAP.enums.Status;
import com.afminguela.CAP.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByStatus(Status status);

    List<Employee> findEmployeesByDepartment(Department department);
}
