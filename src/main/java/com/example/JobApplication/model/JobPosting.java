package com.example.JobApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "job_posting")
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_posting_id")
    public int id;


    private String position;
    private String company;
    private String description;
    private String requirements;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }


    public List<JobApp> getJobApplications() {
        return jobApps;
    }

    public void setJobApplications(List<JobApp> jobApplications) {
        this.jobApps = jobApplications;
    }

    @OneToMany(mappedBy = "jobPosting")
    private List<JobApp> jobApps;



}
