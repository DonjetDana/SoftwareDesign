package com.example.JobApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String position;
    private String company;
    private String duration;
    private String responsibilities;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
