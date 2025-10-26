package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "REWARDS")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rewardCreator", nullable = false)
    private User rewardCreator;

    @Column(name = "rewardName", nullable = false)
    private String rewardName;

    @Column(name = "rewardDescription", nullable = false)
    private String description;
      
    @Column(name = "rewardImage", nullable = false)
    private String image;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public void setRewardCreator(User rewardCreator) {
        this.rewardCreator = rewardCreator;
    }
    public User getRewardCreator() {
        return rewardCreator;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }
    public String getRewardName() {
        return rewardName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRewardCreator_Id(){return rewardCreator.getId();}
}
