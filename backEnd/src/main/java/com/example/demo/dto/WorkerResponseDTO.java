package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkerResponseDTO {
    @JsonProperty("id")
    protected long id;

    @JsonProperty("worker_type")
    protected int worker_type;

    @JsonProperty("creator_id")
    protected long creator_id;

    @JsonProperty("workGroup_id")
    protected long workGroup_id;

    @JsonProperty("reward_points_quantity")
    protected int reward_points_quantity;

    @JsonProperty("worker_name")
    protected String worker_name;


    public WorkerResponseDTO() {}

    public WorkerResponseDTO(long id, long creator_id, long workGroup_id, int reward_points_quantity, int worker_type, String worker_name) {
        this.id = id;
        this.creator_id = creator_id;
        this.workGroup_id = workGroup_id;
        this.reward_points_quantity = reward_points_quantity;
        this.worker_type = worker_type;
        this.worker_name = worker_name;
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

    public int getWorker_type() {
        return worker_type;
    }
    public void setWorker_type(int worker_type) {
        this.worker_type = worker_type;
    }

    public String getWorker_name() {
        return worker_name;
    }
    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }
}
