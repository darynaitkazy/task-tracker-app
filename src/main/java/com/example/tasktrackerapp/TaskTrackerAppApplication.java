package com.example.tasktrackerapp;

import com.example.tasktrackerapp.entity.Project;
import com.example.tasktrackerapp.entity.User;
import com.example.tasktrackerapp.repository.ProjectRepository;
import com.example.tasktrackerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setPassword("should be hashed");
		user.setUsername("John");

		Project project = new Project();
		project.setContent("Upload video to YT");
		user.getProjectList().add(project);

		projectRepository.save(project);
		userRepository.save(user);

	}
}
