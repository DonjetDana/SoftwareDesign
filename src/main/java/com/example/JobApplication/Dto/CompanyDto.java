package com.example.JobApplication.Dto;

import com.example.JobApplication.model.Company;
import com.example.JobApplication.model.Employer;

import java.util.List;

public class CompanyDto {

    private Company company;

    private List<Employer> employers;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }
}
