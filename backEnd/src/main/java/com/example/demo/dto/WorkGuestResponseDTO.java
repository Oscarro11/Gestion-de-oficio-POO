package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkGuestResponseDTO extends WorkerResponseDTO{
    @JsonProperty("identification_code")
    private String identification_code;


    public WorkGuestResponseDTO() {}

    public WorkGuestResponseDTO(
        long id, 
        long creator_id, 
        long workGroup_id, 
        int reward_points_quantity, 
        String identification_code)
        {
            this.id = id;
            this.creatorId = creator_id;
            this.workGroupId = workGroup_id;
            this.rewardPointsQuantity = reward_points_quantity;
            this.identification_code = identification_code;
    }


    public String getIdentification_code() {
        return identification_code;
    }
    public void setIdentification_code(String identification_code) {
        this.identification_code = identification_code;
    }

}
