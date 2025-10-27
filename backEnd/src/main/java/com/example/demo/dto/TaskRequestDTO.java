package com.example.demo.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskRequestDTO {
    @JsonProperty("taskname")
    private String taskname;  

    @JsonProperty("description")
    private String description;

    @JsonProperty("duration")
    private LocalTime duration;

    @JsonProperty("referenceVideo")
    private String referenceVideo;

    public TaskRequestDTO() {}

    public TaskRequestDTO(String taskname, String description, LocalTime duration, String referenceVideo){
        this.taskname = taskname;
        this.description = description; 
        this.duration = duration;
        this.referenceVideo = referenceVideo;
    }


    public String getTaskname() {
        return taskname;
    }
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getDuration() {
        return duration;
    }
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getReferenceVideo() {
        return referenceVideo;
    }
    public void setReferenceVideo(String referenceVideo) {
        this.referenceVideo = referenceVideo;
    }
}
