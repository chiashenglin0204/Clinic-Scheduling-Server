package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
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

    // Method to get a doctor by UID
    public Doctor getDoctorByUid(Long uid) {
        return doctorRepository.findById(uid).orElse(null);
    }

    // Method to get a list of doctors by specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    // Method to update a doctor
    public Doctor updateDoctor(Long uid, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepository.findById(uid).orElse(null);
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
    public boolean deleteDoctor(Long uid) {
        if (doctorRepository.existsById(uid)) {
            doctorRepository.deleteById(uid);
            return true;
        } else {
            return false;
        }
    }
}
