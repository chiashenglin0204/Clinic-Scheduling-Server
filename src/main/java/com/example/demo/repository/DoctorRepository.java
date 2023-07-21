package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
        // Custom query method to find doctors by specialization
    List<Doctor> findBySpecialization(String specialization);
}
