package com.example.tasktrackerapp.repository;

import com.example.tasktrackerapp.entity.Project;
import com.example.tasktrackerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
