package com.example.JobApplication.Repository;

import com.example.JobApplication.model.Role;
import com.example.JobApplication.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
}
