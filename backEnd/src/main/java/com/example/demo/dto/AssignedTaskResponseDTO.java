package com.example.demo.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignedTaskResponseDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("reference_id")
    private Long reference_id;

    @JsonProperty("administrator_id")
    private Long administrator_id;

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

    public AssignedTaskResponseDTO(long reference_id, LocalTime startline, LocalTime endline, Long worker_id, int reward_points){
        this.reference_id = reference_id;
        this.startline = startline;
        this.endline = endline;
        this.worker_id = worker_id;
        this.reward_points = reward_points;
    }

    public Long getAdministrator_id() {
        return administrator_id;
    }
    public void setAdministrator_id(Long administrator_id) {
        this.administrator_id = administrator_id;
    }

    public Long getWorker_id() {
        return worker_id;
    }
    public void setWorker_id(Long worker_id) {
        this.worker_id = worker_id;
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

}