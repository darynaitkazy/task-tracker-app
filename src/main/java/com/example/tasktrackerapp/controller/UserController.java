package com.example.tasktrackerapp.controller;

import com.example.tasktrackerapp.entity.Project;
import com.example.tasktrackerapp.entity.Task;
import com.example.tasktrackerapp.entity.User;
import com.example.tasktrackerapp.repository.ProjectRepository;
import com.example.tasktrackerapp.repository.TaskRepository;
import com.example.tasktrackerapp.repository.UserRepository;
import com.example.tasktrackerapp.request.AddProjectRequest;
import com.example.tasktrackerapp.request.AddTaskRequest;
import com.example.tasktrackerapp.request.AddUserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public UserController(UserRepository userRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PostMapping
    public User addUser(@RequestBody AddUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/projects")
    public void addProject(@PathVariable Long userId, @RequestBody AddProjectRequest projectRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Project project = new Project();
        project.setContent(projectRequest.getContent());
        project.setBeginningDate(projectRequest.getBeginningDate());
        project.setCompletionDate(projectRequest.getCompletionDate());
        project.setPriority(projectRequest.getPriority());
        user.getProjectList().add(project);
        userRepository.save(user);
    }

    @PostMapping("/{projectId}/tasks")
    public void addTask(@PathVariable Long projectId, @RequestBody AddTaskRequest taskRequest) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        project.getTaskList().add(task);
        projectRepository.save(project);
    }

    @PostMapping("projects/{projectId}")
    public void toggleProjectCompleted(@PathVariable Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        project.setCompleted(!project.getCompleted());
        projectRepository.save(project);
    }

    @PostMapping("tasks/{taskId}")
    public void toggleTaskCompleted(@PathVariable Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException());
        task.setCompleted(!task.getCompleted());
        taskRepository.save(task);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody AddUserRequest userRequest) {
        User user  = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }

    @PutMapping("/projects/{projectId}")
    public void updateProject(@PathVariable Long projectId, @RequestBody AddProjectRequest projectRequest) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        project.setContent(projectRequest.getContent());
        project.setBeginningDate(projectRequest.getBeginningDate());
        project.setCompletionDate(projectRequest.getCompletionDate());
        project.setPriority(projectRequest.getPriority());
        projectRepository.save(project);
    }

    @PutMapping("projects/tasks/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody AddTaskRequest taskRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException());
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        taskRepository.save(task);
    }

    @DeleteMapping("{userId}/projects/{projectId}/{taskId}")
    public void deleteTask(@PathVariable Long userId, @PathVariable Long projectId, @PathVariable Long taskId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException());
        project.getTaskList().remove(task);
        taskRepository.delete(task);
    }

    @DeleteMapping("{userId}/projects/{projectId}")
    public void deleteProject(@PathVariable Long userId,@PathVariable Long projectId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        user.getProjectList().remove(project);
        projectRepository.delete(project);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }

}
