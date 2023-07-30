package com.example.demo.service;

import com.example.demo.entity.DoctorWorkingHours;
import com.example.demo.repository.DoctorWorkingHoursRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorWorkingHoursService {

    private final DoctorWorkingHoursRepository doctorWorkingHoursRepository;

    public DoctorWorkingHoursService(DoctorWorkingHoursRepository doctorWorkingHoursRepository) {
        this.doctorWorkingHoursRepository = doctorWorkingHoursRepository;
    }

    // Method to create a new DoctorWorkingHours
    public DoctorWorkingHours createDoctorWorkingHours(DoctorWorkingHours doctorWorkingHours) {
        return doctorWorkingHoursRepository.save(doctorWorkingHours);
    }

    // Method to get DoctorWorkingHours by ID
    public DoctorWorkingHours getDoctorWorkingHoursById(Long id) {
        return doctorWorkingHoursRepository.findById(id).orElse(null);
    }

    // Method to update a DoctorWorkingHours
    public DoctorWorkingHours updateDoctorWorkingHours(Long id, DoctorWorkingHours updatedDoctorWorkingHours) {
        DoctorWorkingHours existingDoctorWorkingHours = doctorWorkingHoursRepository.findById(id).orElse(null);
        if (existingDoctorWorkingHours != null) {
            // Update the DoctorWorkingHours details based on the updatedDoctorWorkingHours object
            // For example:
            existingDoctorWorkingHours.setWeekday(updatedDoctorWorkingHours.getWeekday());
            existingDoctorWorkingHours.setStartTime(updatedDoctorWorkingHours.getStartTime());
            existingDoctorWorkingHours.setEndTime(updatedDoctorWorkingHours.getEndTime());
            // ... other DoctorWorkingHours-specific attributes

            return doctorWorkingHoursRepository.save(existingDoctorWorkingHours);
        } else {
            return null;
        }
    }

    // Method to delete a DoctorWorkingHours
    public boolean deleteDoctorWorkingHours(Long id) {
        if (doctorWorkingHoursRepository.existsById(id)) {
            doctorWorkingHoursRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
