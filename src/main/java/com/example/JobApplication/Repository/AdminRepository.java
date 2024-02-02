package com.example.JobApplication.Repository;

import com.example.JobApplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
