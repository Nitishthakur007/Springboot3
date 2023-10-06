package com.example.project.service;

import com.example.project.Model.Patient;
import com.example.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    public HttpStatus registerPatient(Patient thePatient) {
        patientRepository.save(thePatient);
        return HttpStatus.OK;
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }


    public Patient findById(String patientId) {
        Optional<Patient> result = patientRepository.findById(patientId);
        Patient thePatient = null;

        if(result.isPresent()){
            thePatient = result.get();
        }else {
            throw new RuntimeException("Did not find patient id - "+patientId);
        }
        return thePatient;
    }

    public void deleteById(String id) {
        patientRepository.deleteById(id);
    }
}