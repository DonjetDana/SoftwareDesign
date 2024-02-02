package com.example.JobApplication.Service;

import com.example.JobApplication.model.Employer;
import com.example.JobApplication.model.JobPosting;

import java.util.List;

public interface IJobPostingService {
    JobPosting saveJob(int employerId ,List<JobPosting>jobPostings);
    boolean updateJobPosting(int JobPostingId,String newPosition,String newRequirements,String newDescription,String compnay,Employer employer);

    boolean deleteJobPosting(int JobPostingId);

}
