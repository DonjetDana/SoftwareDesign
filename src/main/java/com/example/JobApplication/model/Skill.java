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
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    private String profiencyLevel;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfiencyLevel() {
        return profiencyLevel;
    }

    public void setProfiencyLevel(String profiencyLevel) {
        this.profiencyLevel = profiencyLevel;
    }

//    public Applicant getApplicant() {
//        return applicant;
//    }
//
//    public void setApplicant(Applicant applicant) {
//        this.applicant = applicant;
//    }
}