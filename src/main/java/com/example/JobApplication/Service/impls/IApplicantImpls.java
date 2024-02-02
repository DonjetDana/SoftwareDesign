package com.example.JobApplication.Service.impls;

import com.example.JobApplication.Repository.ApplicantRepository;
import com.example.JobApplication.Repository.CertificationRepository;
import com.example.JobApplication.Repository.EducationRepository;
import com.example.JobApplication.Repository.SkillRepository;
import com.example.JobApplication.Service.IApplicantService;
import com.example.JobApplication.model.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IApplicantImpls implements IApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private CertificationRepository certificationRepository;

    public void saveWorkExperience(int applicantId, WorkExperience workExperience) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            workExperience.setApplicant(applicant);
            applicant.getWorkExperiences().add(workExperience);
            applicantRepository.save(applicant);
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

    public void saveSkills(int applicantId, List<Skill> skills) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            List<Skill> skillList = skills.stream()
                    .map(skillDto -> {
                        Skill skill = new Skill();
                        skill.setName(skillDto.getName());
                        skill.setProfiencyLevel(skillDto.getProfiencyLevel());
                        skill.setApplicant(applicant); // Set the applicant for the skill
                        skillRepository.save(skill);
                        return skill;
                    })
                    .collect(Collectors.toList());

            applicant.setSkills(skillList);
            applicantRepository.save(applicant);
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

    public void saveEducation(int applicantId, List<Education> educationList) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            educationList.forEach(education -> {
                education.setApplicant(applicant); // Set the applicant for the education
                educationRepository.save(education);
            });

            applicant.setEducation(educationList);
            applicantRepository.save(applicant);
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

    public void saveCertification(int applicantId, List<Certification> certification) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            certification.forEach(certification1 -> {
                certification1.setApplicant(applicant); // Set the applicant for the education
                certificationRepository.save(certification1);
            });

            applicant.setCertification(certification);
            applicantRepository.save(applicant);
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

//    public void deleteEducation(int applicantId, int educationId) {
//        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
//
//        if (applicantOptional.isPresent()) {
//            Applicant applicant = applicantOptional.get();
//
//            // Use JPA's deleteById to remove the education by ID
//            educationRepository.deleteById(educationId);
//
//            // Remove the education from the list in memory
//            applicant.getEducation().removeIf(education -> education.getId() == educationId);
//
//            // Save the applicant to update the education list in the database
//            applicantRepository.save(applicant);
//        } else {
//            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
//        }
//    }
// Inside the Applicant class

    public void editEducation(int applicantId, int educationId, Education updatedEducation) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            List<Education> educationList = applicant.getEducation();

            Optional<Education> educationOptional = educationList.stream()
                    .filter(education -> education.getId() == educationId)
                    .findFirst();

            if (educationOptional.isPresent()) {
                Education existingEducation = educationOptional.get();

                // Update the existing education with the new details
                existingEducation.setDegree(updatedEducation.getDegree());
                existingEducation.setSchool(updatedEducation.getSchool());
                existingEducation.setGraduationYear(updatedEducation.getGraduationYear());

                // Save the updated education
                educationRepository.save(existingEducation);
            } else {
                throw new EntityNotFoundException("Education not found with ID: " + educationId);
            }
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

    public void editCertification(int applicantId, int certificationId, Certification updatedCertification) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            List<Certification> certificationList = applicant.getCertification();

            Optional<Certification> certificationOptional = certificationList.stream()
                    .filter(certification -> certification.getId() == certificationId)
                    .findFirst();

            if (certificationOptional.isPresent()) {
                Certification existingCertification = certificationOptional.get();

                // Update the existing certification with the new details
                existingCertification.setName(updatedCertification.getName());
                existingCertification.setIssuingAuthority(updatedCertification.getIssuingAuthority());
                existingCertification.setDataEarned(updatedCertification.getDataEarned());

                // Save the updated certification
                applicantRepository.save(applicant);
            } else {
                throw new EntityNotFoundException("Certification not found with ID: " + certificationId);
            }
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

    public void editWorkExperience(int applicantId, int workExperienceId, WorkExperience updatedWorkExperience) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            List<WorkExperience> workExperienceList = applicant.getWorkExperiences();

            Optional<WorkExperience> workExperienceOptional = workExperienceList.stream()
                    .filter(workExperience -> workExperience.getId() == workExperienceId)
                    .findFirst();

            if (workExperienceOptional.isPresent()) {
                WorkExperience existingWorkExperience = workExperienceOptional.get();

                // Update the existing work experience with the new details
                existingWorkExperience.setPosition(updatedWorkExperience.getPosition());
                existingWorkExperience.setCompany(updatedWorkExperience.getCompany());
                existingWorkExperience.setDuration(updatedWorkExperience.getDuration());
                existingWorkExperience.setResponsibilities(updatedWorkExperience.getResponsibilities());

                // Save the updated work experience
                applicantRepository.save(applicant);
            } else {
                throw new EntityNotFoundException("Work Experience not found with ID: " + workExperienceId);
            }
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }

    public void editSkill(int applicantId, int skillId, Skill updatedSkill) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);

        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();

            List<Skill> skillList = applicant.getSkills();

            Optional<Skill> skillOptional = skillList.stream()
                    .filter(skill -> skill.getId() == skillId)
                    .findFirst();

            if (skillOptional.isPresent()) {
                Skill existingSkill = skillOptional.get();

                // Update the existing skill with the new details
                existingSkill.setName(updatedSkill.getName());
                existingSkill.setProfiencyLevel(updatedSkill.getProfiencyLevel());

                // Save the updated skill
                applicantRepository.save(applicant);
            } else {
                throw new EntityNotFoundException("Skill not found with ID: " + skillId);
            }
        } else {
            throw new EntityNotFoundException("Applicant not found with ID: " + applicantId);
        }
    }
}
