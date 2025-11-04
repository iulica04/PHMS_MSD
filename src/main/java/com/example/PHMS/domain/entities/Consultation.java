package com.example.PHMS.domain.entities;

import com.example.PHMS.domain.enums.ConsultationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Consultation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Medic doctor;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    @Column(length = 500)
    private String notes; // doctorul poate scrie observații generale

    @Enumerated(EnumType.STRING)
    private ConsultationStatus status;

    public Consultation() {}

    public Consultation(Patient patient, Medic doctor, LocalDateTime appointmentDate, String notes, ConsultationStatus status) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.notes = notes;
        this.status = status;
    }

    public UUID getId() { return id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Medic getDoctor() { return doctor; }
    public void setDoctor(Medic doctor) { this.doctor = doctor; }

    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public ConsultationStatus getStatus() { return status; }
    public void setStatus(ConsultationStatus status) { this.status = status; }
}
