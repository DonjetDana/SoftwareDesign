package com.example.JobApplication;

import com.example.JobApplication.Repository.ApplicantRepository;
import com.example.JobApplication.Repository.RoleRepository;
import com.example.JobApplication.Repository.UserRepository;
import com.example.JobApplication.model.Applicant;
import com.example.JobApplication.model.Role;
import com.example.JobApplication.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, ApplicantRepository applicantRepository){
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			Role companyRole = roleRepository.save(new Role("COMPANY"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			Set<Role> roles2 = new HashSet<>();
			roles2.add(companyRole);
			;




			Applicant admin = new Applicant( "admin", "password",roles);
			Applicant company = new Applicant( "company", "password", roles2);




			applicantRepository.save(admin);
			applicantRepository.save(company);
		};
	}
}
