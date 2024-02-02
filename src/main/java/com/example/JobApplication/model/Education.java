package com.example.JobApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String degree;
    private String school;
    private int graduationYear;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Education() {
    }

    public Education(int id, String degree, String school, int graduationYear, Applicant applicant) {
        this.id = id;
        this.degree = degree;
        this.school = school;
        this.graduationYear = graduationYear;
        this.applicant = applicant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}

