package com.example.JobApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "roles_id")
    private int id;

    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Role(int id, String authority) {
        this.id = id;
        this.authority = authority;
    }
}
