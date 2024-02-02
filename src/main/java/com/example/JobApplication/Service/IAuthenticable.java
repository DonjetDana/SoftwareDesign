package com.example.JobApplication.Service;

import com.example.JobApplication.Dto.LoginDto;
import com.example.JobApplication.model.User;

public interface IAuthenticable {

    LoginDto loginUser(User user);

    boolean changePassword(String oldPassword,String newPassword);

    void updateEmail(String oldEmail,String newEmail);

    User saveUser(String username, String password);
}
