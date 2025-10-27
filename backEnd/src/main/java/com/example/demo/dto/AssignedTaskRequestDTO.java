package com.example.demo.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignedTaskRequestDTO {
    @JsonProperty("reference_id")
    private Long reference_Task_id;

    @JsonProperty("startline")
    private LocalTime startline;

    @JsonProperty("endline")
    private LocalTime endline;

    @JsonProperty("worker_id")
    private Long worker_id;

    @JsonProperty("rewardPoints")
    private int reward_points;

    public AssignedTaskRequestDTO() {}

    public AssignedTaskRequestDTO(long reference_Task_id, LocalTime startline, LocalTime endline, Long collaborator_id, int reward_points){
        this.reference_Task_id = reference_Task_id;
        this.startline = startline;
        this.endline = endline;
        this.worker_id = collaborator_id;
        this.reward_points = reward_points;
    }

    public Long getWorker_id() {
        return worker_id;
    }
    public void setWorker_id(Long collaborator_id) {
        this.worker_id = collaborator_id;
    }

    public LocalTime getEndline() {
        return endline;
    }
    public void setEndline(LocalTime endline) {
        this.endline = endline;
    }

    public Long getReference_Task_id() {
        return reference_Task_id;
    }
    public void setReference_Task_id(Long reference_Task_id) {
        this.reference_Task_id = reference_Task_id;
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

}
