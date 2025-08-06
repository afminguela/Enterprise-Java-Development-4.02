package com.afminguela.CAP.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String name;
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee admitted_by;




}
