package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailableRewardResponseDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("reference_id")
    private long reference_id;

    @JsonProperty("source_id")
    private long source_id;

    @JsonProperty("points_value")
    private int points_value;

    @JsonProperty("stocks_quantity")
    private int stocks_quantity;


    public AvailableRewardResponseDTO() {}

    public AvailableRewardResponseDTO(long id, long reference_id, long source_id, int points_value, int stocks_quantity){
        this.id = id;
        this.reference_id = reference_id;
        this.source_id = source_id;
        this.points_value = points_value;
        this.stocks_quantity = stocks_quantity;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getPoints_value() {
        return points_value;
    }
    public void setPoints_value(int points_value) {
        this.points_value = points_value;
    }

    public long getReference_id() {
        return reference_id;
    }
    public void setReference_id(long reference_id) {
        this.reference_id = reference_id;
    }
    
    public long getSource_id() {
        return source_id;
    }
    public void setSource_id(long source_id) {
        this.source_id = source_id;
    }
    
    public int getStocks_quantity() {
        return stocks_quantity;
    }
    public void setStocks_quantity(int stocks_quantity) {
        this.stocks_quantity = stocks_quantity;
    }
}
