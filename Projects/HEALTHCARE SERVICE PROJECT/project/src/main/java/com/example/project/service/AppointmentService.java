package com.example.project.service;

import com.example.project.Model.Appointment;
import com.example.project.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService{

@Autowired
private  AppointmentRepository appointmentRepository;
    public void deleteAppointment(String appintId) {
        appointmentRepository.deleteById(appintId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public HttpStatus registerAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return HttpStatus.OK;
    }


    public Appointment findById(String appointmentId) {
        Optional<Appointment> result = appointmentRepository.findById(appointmentId);
        Appointment theAppointment = null;

        if(result.isPresent()){
            theAppointment = result.get();
        }else {
            throw new RuntimeException("Did not find Appointmet id - "+appointmentId);
        }
        return theAppointment;
    }

    public List<Appointment> findByPatientId(String patientId) {
        List<Appointment> allAppoinntments;
        Optional<Appointment> result = appointmentRepository.findById(patientId);

        if(result.isPresent()){
            result.get();
        }else {
            throw new RuntimeException("Did not find Appointmet id - "+patientId);
        }

        return null;
    }

}