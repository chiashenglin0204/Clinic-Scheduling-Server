package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Specialization;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
        // Custom query method to find doctors by specialization
    List<Doctor> findBySpecialization(Specialization specialization);
}
