package com.example.JobApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    private String issuingAuthority;
    private LocalDate dataEarned;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}