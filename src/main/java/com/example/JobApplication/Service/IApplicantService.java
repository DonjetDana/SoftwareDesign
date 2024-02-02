package com.example.JobApplication.Service;

import com.example.JobApplication.model.Certification;
import com.example.JobApplication.model.Education;
import com.example.JobApplication.model.Skill;
import com.example.JobApplication.model.WorkExperience;

import java.util.List;

public interface IApplicantService {

    void saveWorkExperience(int applicantId, WorkExperience workExperience);

    void saveSkills(int applicantId, List<Skill> skills);

    void saveEducation(int applicantId, List<Education> educationList);

    void saveCertification(int applicantId, List<Certification> certification);

    void editEducation(int applicantId, int educationId, Education updatedEducation);

    void editCertification(int applicantId, int certificationId, Certification updatedCertification);

    void editWorkExperience(int applicantId, int workExperienceId, WorkExperience updatedWorkExperience);

    void editSkill(int applicantId, int skillId, Skill updatedSkill);

}
