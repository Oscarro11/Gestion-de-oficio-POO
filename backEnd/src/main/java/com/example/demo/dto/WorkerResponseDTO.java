package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class WorkerResponseDTO {
    @JsonProperty("id")
    protected long id;

    @JsonProperty("creator_id")
    protected long creator_id;

    @JsonProperty("workGroup_id")
    protected long workGroup_id;

    @JsonProperty("reward_points_quantity")
    protected int reward_points_quantity;

    @JsonProperty("assignedTasks_id_list")
    protected List<Long> assignedTasks_id_list;


    public WorkerResponseDTO() {}

    public WorkerResponseDTO(long id, long creator_id, long workGroup_id, int reward_points_quantity, List<Long> assignedTasks_id_list){
        this.id = id;
        this.creator_id = creator_id;
        this.workGroup_id = workGroup_id;
        this.reward_points_quantity = reward_points_quantity;
        this.assignedTasks_id_list = assignedTasks_id_list;
    }


    public List<Long> getAssignedTasks_id_list() {
        return assignedTasks_id_list;
    }
    public void setAssignedTasks_id_list(List<Long> assignedTasks_id_list) {
        this.assignedTasks_id_list = assignedTasks_id_list;
    }

    public long getCreator_id() {
        return creator_id;
    }
    public void setCreator_id(long creator_id) {
        this.creator_id = creator_id;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getReward_points_quantity() {
        return reward_points_quantity;
    }
    public void setReward_points_quantity(int reward_points_quantity) {
        this.reward_points_quantity = reward_points_quantity;
    }

    public long getWorkGroup_id() {
        return workGroup_id;
    }
    public void setWorkGroup_id(long workGroup_id) {
        this.workGroup_id = workGroup_id;
    }
}
