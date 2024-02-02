package com.example.JobApplication.Service;

import com.example.JobApplication.Dto.LoginDto;
import com.example.JobApplication.Dto.UserDto;
import com.example.JobApplication.Repository.ApplicantRepository;
import com.example.JobApplication.Repository.EducationRepository;
import com.example.JobApplication.Repository.RoleRepository;
import com.example.JobApplication.Repository.SkillRepository;
import com.example.JobApplication.model.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobAppService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private EducationRepository educationRepository;


    public Applicant saveUser(String username, String password) {
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return applicantRepository.save(new Applicant(username, password, authorities));
    }

    public LoginDto loginUser(UserDto userDto) {
        Optional<Applicant> userOptional = applicantRepository.findByUsername(userDto.getUsername());

        if (userOptional.isPresent()) {
            Applicant user = userOptional.get();

            // Use .equals() for string comparison
            if (user.getPassword().equals(userDto.getPassword())) {
                return new LoginDto(user);
            }
        }

        return null;
    }

//    public void saveWorkExperience(int applicantId, WorkExperience workExperience) {
//        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
//
//        if (applicantOptional.isPresent()) {
//            Applicant applicant = applicantOptional.get();
//            workExperience.setApplicant(applicant);
//            applicant.getWorkExperiences().add(workExperience);
//            applicantRepository.save(applicant);
//        } else {
//            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
//        }
//    }
//
//    public void saveSkills(int applicantId, List<Skill> skills) {
//        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
//
//        if (applicantOptional.isPresent()) {
//            Applicant applicant = applicantOptional.get();
//
//            List<Skill> skillList = skills.stream()
//                    .map(skillDto -> {
//                        Skill skill = new Skill();
//                        skill.setName(skillDto.getName());
//                        skill.setProfiencyLevel(skillDto.getProfiencyLevel());
//                        skill.setApplicant(applicant); // Set the applicant for the skill
//                        skillRepository.save(skill);
//                        return skill;
//                    })
//                    .collect(Collectors.toList());
//
//            applicant.setSkills(skillList);
//            applicantRepository.save(applicant);
//        } else {
//            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
//        }
//    }
//
//    public void saveEducation(int applicantId, List<Education> educationList) {
//        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
//
//        if (applicantOptional.isPresent()) {
//            Applicant applicant = applicantOptional.get();
//
//            educationList.forEach(education -> {
//                education.setApplicant(applicant); // Set the applicant for the education
//                educationRepository.save(education);
//            });
//
//            applicant.setEducation(educationList);
//            applicantRepository.save(applicant);
//        } else {
//            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
//        }
//    }


//    public Applicant saveSkills(A, List<Skill> skills) {
//        if (skills == null) {
//            throw new IllegalArgumentException("Skills cannot be null");
//        }
//
//        List<Skill> skillList = skills.stream()
//                .map(skillDto -> {
//                    Skill skill = new Skill();
//                    skill.setName(skill.getName());
//                    skill.setProfiencyLevel(skill.getProfiencyLevel());

//                    return skill;
//                })
//                .collect(Collectors.toList());
//
//        applicant.setSkills(skillList);
//
//        for (Skill skill : skillList) {
//            skillRepository.save(skill);
//        }
//
//        applicantRepository.save(applicant);
//        return applicant;
//    }


    }
