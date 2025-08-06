package com.afminguela.CAP.service;


import com.afminguela.CAP.Repository.PatientRepository;
import com.afminguela.CAP.enums.Department;
import com.afminguela.CAP.enums.Status;
import com.afminguela.CAP.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient (Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(Long id){
        return patientRepository.findById(id);
    }

    public List<Patient> findByDateOfBirth(LocalDate birthDate){
        return patientRepository.findByBirthDate(birthDate);
    }

    public List<Patient> findAllPatients(){
        return patientRepository.findAll();
    }

    public List<Patient> findAllPatientsByDepartment(String department){
        return patientRepository.findByAdmitted_byDepartments(department);
    }

    public List<Patient> findPatientByStatusOFF(){
        return patientRepository.findByStatusOFF();
    }

}
