package com.example.demo.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignedTaskResponseDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("reference_id")
    private Long reference_id;

    @JsonProperty("startline")
    private LocalTime startline;

    @JsonProperty("endline")
    private LocalTime endline;

    @JsonProperty("worker_id")
    private Long worker_id;

    @JsonProperty("rewardPoints")
    private int reward_points;

    @JsonProperty("status")
    private int status;

    public AssignedTaskResponseDTO() {}

    public AssignedTaskResponseDTO(long reference_id, String name, LocalTime startline, LocalTime endline, Long worker_id, int reward_points){
        this.reference_id = reference_id;
        this.startline = startline;
        this.endline = endline;
        this.worker_id = worker_id;
        this.reward_points = reward_points;
        this.name = name;
    }


    public LocalTime getEndline() {
        return endline;
    }
    public void setEndline(LocalTime endline) {
        this.endline = endline;
    }

    public Long getReference_id() {
        return reference_id;
    }
    public void setReference_id(Long reference_id) {
        this.reference_id = reference_id;
    }

    public Long getWorker_id() {
        return worker_id;
    }
    public void setWorker_id(Long worker_id) {
        this.worker_id = worker_id;
    }

    public int getReward_points() {
        return reward_points;
    }
    public void setReward_points(int reward_points) {
        this.reward_points = reward_points;
    }

    public LocalTime getStartline() {
        return startline;
    }
    public void setStartline(LocalTime startline) {
        this.startline = startline;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}