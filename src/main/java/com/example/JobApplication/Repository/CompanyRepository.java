package com.example.JobApplication.Repository;

import com.example.JobApplication.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
