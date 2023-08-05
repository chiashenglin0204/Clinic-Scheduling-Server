package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client extends User {
    @Id
    @GeneratedValue()
    private Long clientId;
    // Getters and Setters (omitted for brevity)

    // Constructors (omitted for brevity)
}
