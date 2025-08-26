package com.afminguela.CAP.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String name;
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee admitted_by;


    public Long getId() {
        return patient_id;
    }
}
