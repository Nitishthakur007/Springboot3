package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,String>{


}