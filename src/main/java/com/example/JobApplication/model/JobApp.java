package com.example.JobApplication.model;

import com.example.JobApplication.enums.ApplicationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "job_app")
public class JobApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_app_id")
    private int id;

    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    private Applicant applicant;

    private ApplicationStatus applicationStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @ManyToOne
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;


}
