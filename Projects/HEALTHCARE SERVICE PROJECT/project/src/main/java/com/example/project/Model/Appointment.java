package com.example.project.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String booking_id;
    private String disease;

    private Date tentativeDate;
    private String priority;

    private String patientId;
    private Date bookingTime;

    public Appointment( String disease, Date tentativeDate, String priority, String patientId) {
        this.disease = disease;
        this.tentativeDate = tentativeDate;
        this.priority = priority;
        this.patientId = patientId;

    }

}
