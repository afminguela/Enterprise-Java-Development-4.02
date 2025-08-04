package com.afminguela.CAP.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    private String name;
    private Enum department;
    private Enum status;
}
