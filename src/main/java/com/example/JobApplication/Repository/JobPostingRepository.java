package com.example.JobApplication.Repository;

import com.example.JobApplication.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting,Integer> {
}
