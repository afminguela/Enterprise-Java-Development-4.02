package com.afminguela.CAP.Repository;


import com.afminguela.CAP.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByBirthDate(LocalDate birthDate);

//    List<Patient> findByAdmitted_by(Employee admitted_by);

    @Query("SELECT p FROM Patient p JOIN p.admitted_by e WHERE CAST(e.department AS string) LIKE %:department%")
    List<Patient> findByAdmitted_byDepartments(@Param("department") String department);

    @Query("SELECT p FROM Patient p JOIN p.admitted_by e WHERE e.status = 'OFF'")
    List<Patient> findByStatusOFF();


}
