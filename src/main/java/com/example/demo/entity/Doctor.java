package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    @OneToOne
    @JoinColumn(name = "uid", nullable = false, unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    private String clinicLocation;

    // Getters and Setters (omitted for brevity)

    // Constructors (omitted for brevity)
}
