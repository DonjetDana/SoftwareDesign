package com.example.JobApplication.Service;

import com.example.JobApplication.JobApplication;
import com.example.JobApplication.enums.ApplicationStatus;

public interface IApplicationProcessingStatus {

    boolean updateStatus(JobApplication jobApplication, ApplicationStatus applicationStatus);
}
