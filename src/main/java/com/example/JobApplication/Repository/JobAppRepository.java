package com.example.JobApplication.Repository;

import com.example.JobApplication.JobApplication;
import com.example.JobApplication.model.JobApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAppRepository extends JpaRepository<JobApp,Integer> {
}
