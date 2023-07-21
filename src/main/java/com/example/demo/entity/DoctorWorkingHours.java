package com.example.demo.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "doctor_working_hours")
public class DoctorWorkingHours {
    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weekday;
    
    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime breakStart;

    private LocalTime breakEnd;

    // Getters and Setters (omitted for brevity)

    // Constructors (omitted for brevity)
}
