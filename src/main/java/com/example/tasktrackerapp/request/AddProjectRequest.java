package com.example.tasktrackerapp.request;

import java.sql.Date;

public class AddProjectRequest {
    private String content;
    private java.sql.Date beginningDate;
    private java.sql.Date completionDate;
    private int priority;

    public AddProjectRequest() {

    }

    public AddProjectRequest(String content, Date beginningDate, Date completionDate, int priority) {
        this.content = content;
        this.beginningDate = beginningDate;
        this.completionDate = completionDate;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
