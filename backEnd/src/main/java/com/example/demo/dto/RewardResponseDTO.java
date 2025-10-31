package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RewardResponseDTO {
    @JsonProperty("id")
    private long id;

    @JsonProperty("rewardname")
    private String rewardname;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image_url")
    private String image;

    @JsonProperty("creator_id")
    private Long creator_id;

    public RewardResponseDTO() {}

    public RewardResponseDTO(String rewardname, String description, String imageUrl){
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

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Long getCreator_id() {
        return creator_id;
    }
    public void setCreator_id(Long creator_id) {
        this.creator_id = creator_id;
    }
}

