package com.example.JobApplication.Dto;

import com.example.JobApplication.model.JobPosting;

public class JobPostingDto {

    public int id;

    private JobPosting jobPosting;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }


}
