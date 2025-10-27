package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty    ;

public class WorkUserRequestDTO extends WorkerResponseDTO{
    @JsonProperty("identification_code")
    private String identification_code;

    @JsonProperty("name")
    private String name;


    public WorkUserRequestDTO() {}

    public WorkUserRequestDTO(String identification_code, String name){
        this.identification_code = identification_code;
        this.name = name;
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