package com.example.JobApplication.Repository;

import com.example.JobApplication.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification,Integer> {
}
