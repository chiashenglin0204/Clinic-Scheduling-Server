package com.example.demo.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctor_working_hours")
public class DoctorWorkingHours {
    @Id
    @GeneratedValue
    private Long id;

    // Storing the doctor's uid directly in this table as a regular Long attribute
    @Column(nullable = false)
    private Long uid;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weekday;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalTime breakStart;

    private LocalTime breakEnd;

    // Getters and Setters (omitted for brevity)

    // Constructors (omitted for brevity)
}
