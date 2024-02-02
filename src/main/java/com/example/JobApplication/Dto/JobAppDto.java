package com.example.JobApplication.Dto;

import com.example.JobApplication.model.JobApp;

public class JobAppDto {

    private String username;

    private JobApp jobApp;

    public JobAppDto(String username,JobApp jobApp){
        this.username = username;
        this.jobApp = jobApp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JobApp getJobApp() {
        return jobApp;
    }

    public void setJobApp(JobApp jobApp) {
        this.jobApp = jobApp;
    }
}
