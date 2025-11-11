package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkGuestRequestDTO {
    @JsonProperty("guest_name")
    private String name;


    public WorkGuestRequestDTO() {}

    public WorkGuestRequestDTO(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
