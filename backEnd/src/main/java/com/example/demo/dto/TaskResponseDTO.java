package com.example.demo.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskResponseDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("taskname")
    private String taskname;

    @JsonProperty("description")
    private String description;

    @JsonProperty("duration")
    private LocalTime duration;

    @JsonProperty("referenceVideo")
    private String referenceVideo;

    @JsonProperty("taskCreator_id")
    private Long taskCreator_id;

    public TaskResponseDTO() {}

    public TaskResponseDTO(String taskname, String description, LocalTime duration, String referenceVideo, Long creator_id){
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

    public Long getTaskCreator_id() {
        return taskCreator_id;
    }
    public void setTaskCreator_id(Long taskCreator_id) {
        this.taskCreator_id = taskCreator_id;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
