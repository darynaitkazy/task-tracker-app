package com.example.tasktrackerapp.repository;

import com.example.tasktrackerapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}