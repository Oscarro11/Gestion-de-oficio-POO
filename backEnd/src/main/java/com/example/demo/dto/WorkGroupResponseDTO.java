package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkGroupResponseDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("workgroup_name")
    private String workgroup_name;
    
    @JsonProperty("administrator_id")
    private long administrator_id;
    

    public WorkGroupResponseDTO() {}

    public WorkGroupResponseDTO(long id, long administrator_id) {
        this.id = id;
        this.administrator_id = administrator_id;
    }


    public long getAdministrator_id() {
        return administrator_id;
    }
    public void setAdministrator_id(long administrator_id) {
        this.administrator_id = administrator_id;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getWorkgroup_name() {
        return workgroup_name;
    }
    public void setWorkgroup_name(String workgroup_name) {
        this.workgroup_name = workgroup_name;
    }
}
