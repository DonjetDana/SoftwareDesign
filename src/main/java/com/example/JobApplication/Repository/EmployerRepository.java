package com.example.JobApplication.Repository;

import com.example.JobApplication.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Integer> {

}
