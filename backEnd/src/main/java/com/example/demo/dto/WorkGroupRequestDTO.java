package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkGroupRequestDTO {
    @JsonProperty("workGroupName")
    private String workGroupName;


    public WorkGroupRequestDTO() {}

    public WorkGroupRequestDTO(String workGroupName) {
        this.workGroupName = workGroupName;
    }


    public String getWorkGroupName() {
        return workGroupName;
    }
    public void setWorkGroupName(String workGroupName) {
        this.workGroupName = workGroupName;
    }
}
