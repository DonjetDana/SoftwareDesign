package com.example.JobApplication.Repository;

import com.example.JobApplication.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    @Override
    Optional<Education> findById(Integer integer);
}
