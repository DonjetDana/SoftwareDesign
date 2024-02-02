package com.example.JobApplication.Dto;

import java.util.Set;

public class ApplyForJobDTO {
    private int jobPostingId;
    private Set<Integer> applicantIds;

    public int getJobPostingId() {
        return jobPostingId;
    }

    public void setJobPostingId(int jobPostingId) {
        this.jobPostingId = jobPostingId;
    }

    public Set<Integer> getApplicantIds() {
        return applicantIds;
    }

    public void setApplicantIds(Set<Integer> applicantIds) {
        this.applicantIds = applicantIds;
    }
}
