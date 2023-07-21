package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
        // Custom query method to find doctors by specialization
    List<Doctor> findBySpecialization(String specialization);
}
