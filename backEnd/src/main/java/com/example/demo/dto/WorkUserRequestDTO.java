package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty    ;

public class WorkUserRequestDTO{
    @JsonProperty("reference_id")
    private Long reference_id;


    public WorkUserRequestDTO() {}

    public WorkUserRequestDTO(Long reference_id){
        this.reference_id = reference_id;
    }

    public Long getReference_id() {
        return reference_id;
    }
    public void setReference_id(Long reference_id) {
        this.reference_id = reference_id;
    }
}