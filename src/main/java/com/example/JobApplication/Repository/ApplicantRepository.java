package com.example.JobApplication.Repository;

import com.example.JobApplication.Dto.UserDto;
import com.example.JobApplication.model.Applicant;
import com.example.JobApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository  extends JpaRepository<Applicant,Integer> {

    Optional<Applicant> findByUsername(String username);
}
