package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RewardRequestDTO {
    @JsonProperty("rewardname")
    private String rewardname;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image-url")
    private String image;

    public RewardRequestDTO() {}

    public RewardRequestDTO(String rewardname, String description, String imageUrl){
        this.rewardname = rewardname;
        this.description = description;
        this.image = imageUrl;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getRewardname() {
        return rewardname;
    }
    public void setRewardname(String rewardname) {
        this.rewardname = rewardname;
    }
}
