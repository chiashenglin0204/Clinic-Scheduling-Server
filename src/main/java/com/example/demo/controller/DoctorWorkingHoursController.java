package com.example.demo.controller;

import com.example.demo.entity.DoctorWorkingHours;
import com.example.demo.service.DoctorWorkingHoursService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor-working-hours")
public class DoctorWorkingHoursController {

    private final DoctorWorkingHoursService doctorWorkingHoursService;

    public DoctorWorkingHoursController(DoctorWorkingHoursService doctorWorkingHoursService) {
        this.doctorWorkingHoursService = doctorWorkingHoursService;
    }

    // Endpoint to create a new DoctorWorkingHours
    @PostMapping("/create")
    public ResponseEntity<DoctorWorkingHours> createDoctorWorkingHours(@RequestBody DoctorWorkingHours doctorWorkingHours) {
        DoctorWorkingHours createdDoctorWorkingHours = doctorWorkingHoursService.createDoctorWorkingHours(doctorWorkingHours);
        return new ResponseEntity<>(createdDoctorWorkingHours, HttpStatus.CREATED);
    }

    // Endpoint to get DoctorWorkingHours by ID
    @GetMapping("/{id}")
    public ResponseEntity<DoctorWorkingHours> getDoctorWorkingHoursById(@PathVariable Long id) {
        DoctorWorkingHours doctorWorkingHours = doctorWorkingHoursService.getDoctorWorkingHoursById(id);
        if (doctorWorkingHours != null) {
            return new ResponseEntity<>(doctorWorkingHours, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to update a DoctorWorkingHours
    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorWorkingHours> updateDoctorWorkingHours(@PathVariable Long id, @RequestBody DoctorWorkingHours updatedDoctorWorkingHours) {
        DoctorWorkingHours updatedDoctorWorkingHoursData = doctorWorkingHoursService.updateDoctorWorkingHours(id, updatedDoctorWorkingHours);
        if (updatedDoctorWorkingHoursData != null) {
            return new ResponseEntity<>(updatedDoctorWorkingHoursData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a DoctorWorkingHours
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDoctorWorkingHours(@PathVariable Long id) {
        boolean deleted = doctorWorkingHoursService.deleteDoctorWorkingHours(id);
        if (deleted) {
            return new ResponseEntity<>("DoctorWorkingHours deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DoctorWorkingHours not found", HttpStatus.NOT_FOUND);
        }
    }
}