package com.example.JobApplication.model;

import com.example.JobApplication.enums.EUserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User{

    EUserStatus status = EUserStatus.ACTIVE;
    public Admin() {
    }

    public Admin(String username, String password, Set<Role> authorities) {
        super(username, password, authorities);
    }
}
