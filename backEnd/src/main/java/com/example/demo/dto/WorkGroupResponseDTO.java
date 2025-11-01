package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WorkGroupResponseDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("workgroup_name")
    private String workgroup_name;
    
    @JsonProperty("administrator_id")
    private long administrator_id;

    @JsonProperty("workers_id_list")
    private List<Long> workers_id_list;
    
    @JsonProperty("rewards_id_list")
    private List<Long> rewards_id_list;
    

    public WorkGroupResponseDTO() {}

    public WorkGroupResponseDTO(long id, long administrator_id, List<Long> workers_id_list, List<Long> rewards_id_list) {
        this.id = id;
        this.administrator_id = administrator_id;
        this.workers_id_list = workers_id_list;
        this.rewards_id_list = rewards_id_list;
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

    public List<Long> getRewards_id_list() {
        return rewards_id_list;
    }
    public void setRewards_id_list(List<Long> rewards_id_list) {
        this.rewards_id_list = rewards_id_list;
    }

    public List<Long> getWorkers_id_list() {
        return workers_id_list;
    }
    public void setWorkers_id_list(List<Long> workers_id_list) {
        this.workers_id_list = workers_id_list;
    }

    public String getWorkgroup_name() {
        return workgroup_name;
    }
    public void setWorkgroup_name(String workgroup_name) {
        this.workgroup_name = workgroup_name;
    }
}
