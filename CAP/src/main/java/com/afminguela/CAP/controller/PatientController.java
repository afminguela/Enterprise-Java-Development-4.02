package com.afminguela.CAP.controller;


import com.afminguela.CAP.model.Patient;

import com.afminguela.CAP.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Patiente")
public class PatientController {
    @Autowired
    private PatientService patientService;
//    @Autowired
//    private ResponseEntityExceptionHandler responseEntityExceptionHandler;

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientService.findAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id){
        Optional<Patient> patient = patientService.findPatientById(id);
        return patient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/birthDate/{birthDate}")
    public ResponseEntity<List<Patient>> findByBirthDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate birthDate){
        List<Patient> patients =patientService.findByDateOfBirth(birthDate);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/search/department/{department}")
    public List<Patient> findByDepartment(@PathVariable String department){
        return patientService.findAllPatientsByDepartment(department);
    }

    @GetMapping("/search/status/{status}")
    public List<Patient> findByStatus(){
        return patientService.findPatientByStatusOFF();
    }

    @PatchMapping("/{id}/name")
    public ResponseEntity <Patient> updateName(@PathVariable Long id, @RequestParam String name){
        Optional<Patient> patientOpt = patientService.findPatientById(id);
        if(patientOpt.isPresent()){
            Patient patient = patientOpt.get();
            patient.setName(name);
           Patient updated = patientService.savePatient(patient);
            return ResponseEntity.ok(updated);

        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
