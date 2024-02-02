package com.example.JobApplication.Dto;

import com.example.JobApplication.model.Applicant;
import com.example.JobApplication.model.User;

public class LoginDto {

    private Applicant applicant;

    public LoginDto(Applicant applicant) {
        this.applicant = applicant;
    }



    public Applicant getUser() {
        return applicant;
    }

    public void setUser(Applicant user) {
        this.applicant = applicant;
    }
}
