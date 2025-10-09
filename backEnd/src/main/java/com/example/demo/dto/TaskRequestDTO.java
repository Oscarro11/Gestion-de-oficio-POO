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

    @JsonProperty("reference_video")
    private String reference_video;

    @JsonProperty("creator_id")
    private Long creator_id;

    public TaskRequestDTO() {}

    public TaskRequestDTO(String taskname, String description, LocalTime duration, String reference_video){
        this.taskname = taskname;
        this.description = description; 
        this.duration = duration;
        this.reference_video = reference_video;
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

    public String getReference_video() {
        return reference_video;
    }
    public void setReference_video(String reference_video) {
        this.reference_video = reference_video;
    }
}
