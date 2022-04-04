package com.example.tasktrackerapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Project> projectList = new ArrayList<>();

    public User() {

    }

    public User(Long id, String username, String password, List<Project> projectList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.projectList = projectList;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public void deleteAll(List<Project> projectList) {
        projectList.clear();
    }

}
