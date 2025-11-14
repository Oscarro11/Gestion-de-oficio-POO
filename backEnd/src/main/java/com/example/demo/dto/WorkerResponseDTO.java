package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkerResponseDTO {
    @JsonProperty("id")
    protected long id;

    @JsonProperty("workerType")
    protected int workerType;

    @JsonProperty("creatorId")
    protected long creatorId;

    @JsonProperty("workGroupId")
    protected long workGroupId;

    @JsonProperty("rewardPointsQuantity")
    protected int rewardPointsQuantity;

    @JsonProperty("workerName")
    protected String workerName;

    @JsonProperty("datosAdicionales")
    protected String datosAdicionales;


    public WorkerResponseDTO() {}

    public WorkerResponseDTO(long id, long creatorId, long workGroupId, int rewardPointsQuantity, int workerType, String workerName, String datosAdicionales) {
        this.id = id;
        this.creatorId = creatorId;
        this.workGroupId = workGroupId;
        this.rewardPointsQuantity = rewardPointsQuantity;
        this.workerType = workerType;
        this.workerName = workerName;
        this.datosAdicionales = datosAdicionales;
    }


    public long getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getDatosAdicionales() {
        return datosAdicionales;
    }
    public void setDatosAdicionales(String datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public int getRewardPointsQuantity() {
        return rewardPointsQuantity;
    }
    public void setRewardPointsQuantity(int rewardPointsQuantity) {
        this.rewardPointsQuantity = rewardPointsQuantity;
    }

    public long getWorkGroupId() {
        return workGroupId;
    }
    public void setWorkGroupId(long workGroupId) {
        this.workGroupId = workGroupId;
    }
    
    public String getWorkerName() {
        return workerName;
    }
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getWorkerType() {
        return workerType;
    }
    public void setWorkerType(int workerType) {
        this.workerType = workerType;
    }
}
