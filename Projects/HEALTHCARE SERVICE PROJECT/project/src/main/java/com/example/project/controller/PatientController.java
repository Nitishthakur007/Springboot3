package com.example.project.controller;

import com.example.project.Model.ApplicationUser;
import com.example.project.Model.Patient;
import com.example.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<String> registerPatients(@RequestBody Patient thePatient) {
        HttpStatus status = patientService.registerPatient(thePatient);
        if (status == HttpStatus.OK) {
            return new ResponseEntity<>("message= " + "Registration successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("message= " + "Registration failure", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public List<Patient> getAllPatient(){
        return patientService.findAll();
    }


    @GetMapping("/view/{id}")
    public Patient getPatientById(@PathVariable String id) {
        Patient thePatient = patientService.findById(id);
        if(thePatient.equals(null)) {
            throw new RuntimeException();
        }
        return thePatient;
    }



    @DeleteMapping("/delete/{id}")
    public String deleteEmpById(@PathVariable String id) {
        Patient thePatient = patientService.findById(id);
        if(thePatient == null) {
            throw new RuntimeException("Patient id not found- " + id);
        }
        patientService.deleteById(id);
        return "Deleted Employee id: " + id;
    }
}