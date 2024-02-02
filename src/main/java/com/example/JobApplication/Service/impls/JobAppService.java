package com.example.JobApplication.Service.Implementation;

import com.example.JobApplication.Dto.CompanyDto;
import com.example.JobApplication.Dto.EmployerDto;
import com.example.JobApplication.Dto.LoginDto;
import com.example.JobApplication.Dto.UserDto;
import com.example.JobApplication.JobApplication;
import com.example.JobApplication.Repository.*;
import com.example.JobApplication.Service.IApplicationProcessingStatus;
import com.example.JobApplication.Service.IJobPostingService;
import com.example.JobApplication.enums.ApplicationStatus;
import com.example.JobApplication.enums.JobPostingStatus;
import com.example.JobApplication.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobAppService implements IJobPostingService, IApplicationProcessingStatus {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private UserRepository userRepository;









    public Company saveCompany(CompanyDto companyDto) throws IOException {
        if(companyDto.getEmployers() == null){
            throw new IllegalArgumentException("Ingredients cannot be null");
        }

        List<Employer> employerList = companyDto.getEmployers().stream()
                .map(employer1 -> {
                    Employer employer2 = new Employer();
                    employer2.setName(employer1.getName());
                    employer2.setUsername(employer1.getUsername());
                    employer2.setPhone(employer1.getPhone());
                    employer2.setPassword(employer1.getPassword());
                    return employer2;
                })
                .collect(Collectors.toList());


        employerList.forEach(employer -> employer.setCompany(companyDto.getCompany()));

        // Save all employers in one go using saveAll
        employerRepository.saveAll(employerList);

        // Set the list of employers for the company
        companyDto.getCompany().setEmployers(employerList);

        // Save the company
        companyRepository.save(companyDto.getCompany());

        return companyDto.getCompany();
    }

    public JobPosting saveJob(int employerId,List<JobPosting>jobPostings){
        if(jobPostings == null){
            throw new IllegalArgumentException("Ingredients cannot be null");
        }

        Optional<Employer> employerOptional = employerRepository.findById(employerId);

        if(employerOptional.isPresent()){
            Employer employer = employerOptional.get();

            List<JobPosting> jobPostingList = jobPostings.stream()
                    .map(item -> {
                        JobPosting jobPosting2 = new JobPosting();
                        jobPosting2.setCompany(item.getCompany());
                        jobPosting2.setDescription(item.getDescription());
                        jobPosting2.setPosition(item.getRequirements());
                        jobPosting2.setRequirements(item.getRequirements());
                        jobPosting2.setEmployer(employer);
//                        JobPostingStatus jobPostingStatus = JobPostingStatus.ACTIVE;
                        return jobPosting2;
                    })
                    .collect(Collectors.toList());

            jobPostingList.forEach(jobPosting -> jobPostingRepository.save(jobPosting));

            employer.setJobPosting(jobPostingList);
            JobPostingStatus status = JobPostingStatus.ACTIVE;
            employerRepository.save(employer);

        }

        return null;
    }

    @Override
    public boolean updateJobPosting(int JobPostingId, String newPosition, String newRequirements, String newDescription, String compnay, Employer employer) {
        return false;
    }


    @Override
    public boolean deleteJobPosting(int JobPostingId) {
        JobPostingStatus status = JobPostingStatus.EXPIRED;
        return false;
    }

    public boolean updateStatus(JobApplication jobApplication, ApplicationStatus applicationStatus){
        return false;
    }


}
