package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkUserResponseDTO extends WorkerResponseDTO{
    @JsonProperty("reference_id")
    private Long reference_id;


    public WorkUserResponseDTO() {}

    public WorkUserResponseDTO(
        long id, 
        long creator_id, 
        long workGroup_id, 
        int reward_points_quantity, 
        List<Long> assignedTasks_id_list, 
        long reference_id)
        {
            this.id = id;
            this.creator_id = creator_id;
            this.workGroup_id = workGroup_id;
            this.reward_points_quantity = reward_points_quantity;
            this.assignedTasks_id_list = assignedTasks_id_list;
            this.reference_id = reference_id;
        }

    public Long getReference_id() {
        return reference_id;
    }
    public void setReference_id(Long reference_id) {
        this.reference_id = reference_id;
    }
}
