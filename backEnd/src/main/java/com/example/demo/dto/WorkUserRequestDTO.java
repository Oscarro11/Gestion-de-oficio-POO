package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty    ;

public class WorkUserRequestDTO{
    @JsonProperty("user_name")
    private String user_name;


    public WorkUserRequestDTO() {}

    public WorkUserRequestDTO(String user_name){
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}