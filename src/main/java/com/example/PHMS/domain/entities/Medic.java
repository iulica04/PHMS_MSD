package com.example.PHMS.domain.entities;

import com.example.PHMS.domain.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Medic extends User {

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String hospital;

    public Medic() {
        super();
        this.setRole(Role.MEDIC);
    }

    public Medic(String firstName, String lastName, java.time.LocalDate birthDate, String gender,
                 String email, String passwordHash, String phoneNumber, String address,
                 String rank, String specialization, String hospital) {
        super(firstName, lastName, birthDate, gender, email, passwordHash, phoneNumber, address, Role.MEDIC);
        this.rank = rank;
        this.specialization = specialization;
        this.hospital = hospital;
    }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getHospital() { return hospital; }
    public void setHospital(String hospital) { this.hospital = hospital; }
}