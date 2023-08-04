package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Client extends User {
    @Id
    @GeneratedValue()
    private Long clientId;
    // Getters and Setters (omitted for brevity)

    // Constructors (omitted for brevity)
}
