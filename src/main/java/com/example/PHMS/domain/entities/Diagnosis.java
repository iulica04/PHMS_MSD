package com.example.PHMS.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Diagnosis {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Medic doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "disease_type_id")
    private DiseaseType diseaseType;

    @Column(nullable = false)
    private LocalDate diagnosisDate;

    @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreatmentAssignment> treatments;

    @Column(nullable = false)
    private boolean cured = false;

    public Diagnosis() {}

    public Diagnosis(Patient patient, Medic doctor, DiseaseType diseaseType, LocalDate diagnosisDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.diseaseType = diseaseType;
        this.diagnosisDate = diagnosisDate;
    }

    // getters and setters
    public UUID getId() { return id; }
    public Patient getPatient() { return patient; }
    public Medic getDoctor() { return doctor; }
    public DiseaseType getDiseaseType() { return diseaseType; }
    public LocalDate getDiagnosisDate() { return diagnosisDate; }
    public void setDiagnosisDate(LocalDate diagnosisDate) { this.diagnosisDate = diagnosisDate; }
    public List<TreatmentAssignment> getTreatments() { return treatments; }
    public void setTreatments(List<TreatmentAssignment> treatments) { this.treatments = treatments; }
    public boolean isCured() { return cured; }
    public void setCured(boolean cured) { this.cured = cured; }
}
