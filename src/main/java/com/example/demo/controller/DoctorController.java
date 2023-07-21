package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Endpoint to create a new doctor
    @PostMapping("/createDoctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    // Endpoint to get a doctor by ID
    @GetMapping("/{uid}")
    public ResponseEntity<Doctor> getDoctorByUid(@PathVariable Long uid) {
        Doctor doctor = doctorService.getDoctorByUid(uid);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(doctor);
        }
    }

    // Endpoint to get a list of doctors by specialization
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
        List<Doctor> doctors = doctorService.getDoctorsBySpecialization(specialization);
        if (!doctors.isEmpty()) {
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update a doctor
    @PutMapping("/{uid}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long uid, @RequestBody Doctor updatedDoctor) {
        Doctor doctor = doctorService.updateDoctor(uid, updatedDoctor);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a doctor
    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long uid) {
        boolean deleted = doctorService.deleteDoctor(uid);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
