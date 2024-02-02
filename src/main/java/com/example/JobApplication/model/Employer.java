package com.example.JobApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private JobPosting jobPosting;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
}

