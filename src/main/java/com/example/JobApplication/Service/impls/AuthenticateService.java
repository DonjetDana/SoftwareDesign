package com.example.JobApplication.Service.Implementation;

import com.example.JobApplication.Dto.LoginDto;
import com.example.JobApplication.Repository.ApplicantRepository;
import com.example.JobApplication.Repository.RoleRepository;
import com.example.JobApplication.Service.IApplicant;
import com.example.JobApplication.Service.IAuthenticable;
import com.example.JobApplication.model.Applicant;
import com.example.JobApplication.model.Role;
import com.example.JobApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AuthenticateService implements IAuthenticable {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public LoginDto loginUser(User user) {
        Optional<Applicant> userOptional = applicantRepository.findByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            User user1 = userOptional.get();

            // Use .equals() for string comparison
            if (user1.getPassword().equals(user.getPassword())) {
                // Passwords match, create and return LoginDto
                return new LoginDto(user);
            }
        }

        // Return null or throw an exception based on your business logic
        return null;
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void updateEmail(String oldEmail, String newEmail) {
    }

    @Override
    public User saveUser(String username, String password){
        Role userRole = roleRepository.findByAuthority("APPLICANT").get();
        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return  applicantRepository.save(new Applicant(username,password,authorities));
    }
}
