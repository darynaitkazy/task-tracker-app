package com.example.tasktrackerapp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private java.sql.Date beginningDate;
    private java.sql.Date completionDate;
    private Boolean completed = Boolean.FALSE;
    private int priority;


    @OneToMany(cascade = CascadeType.MERGE)
    private List<Task> taskList = new ArrayList<>();

    public Project() {

    }

    public Project(Long id, String content, Date beginningDate, Date completionDate, Boolean completed, int priority) {
        this.id = id;
        this.content = content;
        this.beginningDate = beginningDate;
        this.completionDate = completionDate;
        this.completed = completed;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void deleteTaskList() {
        taskList.clear();
    }
}
