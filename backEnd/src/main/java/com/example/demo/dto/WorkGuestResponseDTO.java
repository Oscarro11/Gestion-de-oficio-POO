package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WorkGuestResponseDTO extends WorkerResponseDTO{
    @JsonProperty("name")
    private String name;

    @JsonProperty("identification_code")
    private String identification_code;


    public WorkGuestResponseDTO() {}

    public WorkGuestResponseDTO(
        long id, 
        long creator_id, 
        long workGroup_id, 
        int reward_points_quantity, 
        List<Long> assignedTasks_id_list, 
        String name, 
        String identification_code)
        {
            this.id = id;
            this.creator_id = creator_id;
            this.workGroup_id = workGroup_id;
            this.reward_points_quantity = reward_points_quantity;
            this.assignedTasks_id_list = assignedTasks_id_list;
            this.name = name;
            this.identification_code = identification_code;
    }


    public String getIdentification_code() {
        return identification_code;
    }
    public void setIdentification_code(String identification_code) {
        this.identification_code = identification_code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
