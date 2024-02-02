package com.example.JobApplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data

@AllArgsConstructor
@Table(name = "applicant")
@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "applicant_id")
    private int id;
    private String name;
    private String username;
    private String password;

    private String phone;
    private String resume;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Education> education;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WorkExperience> workExperiences;

    //    private List<String> languages;
    @OneToMany( cascade = CascadeType.ALL )
    private List<Certification> certification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }


    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }


//    public List<String> getLanguages() {
//        return languages;
//    }
//
//    public void setLanguages(List<String> languages) {
//        this.languages = languages;
//    }


    public List<Certification> getCertification() {
        return certification;
    }

    public void setCertification(List<Certification> certification) {
        this.certification = certification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "applicant_role_junction",
            joinColumns = {@JoinColumn(name = "applicant_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public Applicant(String username, String password, Set<Role> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Applicant() {
    }


}
