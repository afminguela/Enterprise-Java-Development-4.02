package com.afminguela.CAP.service;

import com.afminguela.CAP.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ervice
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;


}
