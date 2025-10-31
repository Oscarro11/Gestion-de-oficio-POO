package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailableRewardRequestDTO {
    @JsonProperty("reference_id")
    private long reference_id;

    @JsonProperty("points_value")
    private int points_value;

    @JsonProperty("stocks_quantity")
    private int stocks_quantity;


    public AvailableRewardRequestDTO() {}

    public AvailableRewardRequestDTO(long reference_id, int points_value, int stocks_quantity){
        this.reference_id = reference_id;
        this.points_value = points_value;
        this.stocks_quantity = stocks_quantity;
    }

    
    public Long getReference_id() {
        return reference_id;
    }
    public void setReference_id(Long reference_id) {
        this.reference_id = reference_id;
    }

    public int getPoints_value() {
        return points_value;
    }
    public void setPoints_value(int points_value) {
        this.points_value = points_value;
    }

    public int getStocks_quantity() {
        return stocks_quantity;
    }
    public void setStocks_quantity(int stocks_quantity) {
        this.stocks_quantity = stocks_quantity;
    }
}
