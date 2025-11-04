package com.example.PHMS.domain.entities;

import com.example.PHMS.domain.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends User {
    public Patient() {
        super();
        this.setRole(Role.PATIENT);
    }

    public Patient(String firstName, String lastName, java.time.LocalDate birthDate, String gender,
                   String email, String passwordHash, String phoneNumber, String address) {
        super(firstName, lastName, birthDate, gender, email, passwordHash, phoneNumber, address, Role.PATIENT);
    }
}
