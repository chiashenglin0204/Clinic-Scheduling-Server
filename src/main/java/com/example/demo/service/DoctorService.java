package com.example.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Specialization;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Method to create a new doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Method to get a doctor by doctorId
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    // Method to get a list of doctors by specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        try {
            Specialization specializationEnum = Specialization.valueOf(specialization.toUpperCase());
            return doctorRepository.findBySpecialization(specializationEnum);
        } catch (IllegalArgumentException ex) {
            // Handle invalid specialization value here
            return Collections.emptyList();
        }
    }

    // Method to update a doctor
    public Doctor updateDoctor(Long doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepository.findById(doctorId).orElse(null);
        if (existingDoctor != null) {
            // Update the doctor details based on the updatedDoctor object
            // For example:
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setContactNumber(updatedDoctor.getContactNumber());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            // ... other doctor-specific attributes

            return doctorRepository.save(existingDoctor);
        } else {
            return null;
        }
    }

    // Method to delete a doctor
    public boolean deleteDoctor(Long doctorId) {
        if (doctorRepository.existsById(doctorId)) {
            doctorRepository.deleteById(doctorId);
            return true;
        } else {
            return false;
        }
    }
}
