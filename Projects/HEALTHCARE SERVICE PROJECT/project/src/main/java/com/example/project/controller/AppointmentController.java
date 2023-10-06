package com.example.project.controller;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAppoinntment(@RequestBody Appointment appointment) {
        HttpStatus status = appointmentService.registerAppointment(appointment);
        if (status == HttpStatus.OK) {
            return new ResponseEntity<>("message= " + "Booking successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("message= " + "Booking failure", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/list")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointments();
    }


    @GetMapping("/view/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable String appointmentId) {
        Appointment theAppoinntment = appointmentService.findById(appointmentId);
        if(theAppoinntment.equals(null)) {
            throw new RuntimeException();
        }
        return theAppoinntment;
    }


    @GetMapping("/list/{patientId}")
    public List<Appointment> getAllAppointmentByPatientId(@PathVariable String patientId){
        List<Appointment> patientAppointments = appointmentService.findByPatientId(patientId);
        return patientAppointments;
    }


    @DeleteMapping("/delete/{appointmentId}")
    public String deleteEmpById(@PathVariable String appointmentId) {
        Appointment theAppointment = appointmentService.findById(appointmentId);
        if(theAppointment == null) {
            throw new RuntimeException("appointment id not found- " + appointmentId);
        }
        appointmentService.deleteAppointment(appointmentId);
        return "Deleted appointment id: " + appointmentId;
    }


}
