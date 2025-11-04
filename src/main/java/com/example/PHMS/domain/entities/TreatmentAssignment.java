package com.example.PHMS.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class TreatmentAssignment {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "treatment_type_id")
    private TreatmentType treatmentType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private boolean active;

    public TreatmentAssignment() {}

    public TreatmentAssignment(TreatmentType treatmentType, Diagnosis diagnosis,
                               LocalDate startDate, LocalDate endDate, boolean active) {
        this.treatmentType = treatmentType;
        this.diagnosis = diagnosis;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }


    public UUID getId() { return id; }
    public TreatmentType getTreatmentType() { return treatmentType; }
    public Diagnosis getDiagnosis() { return diagnosis; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
