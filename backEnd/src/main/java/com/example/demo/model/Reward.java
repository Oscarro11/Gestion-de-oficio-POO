package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "REWARDS")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(name = "name", nullable = false)
    private String rewardName;

    @Column(name = "description")
    private String description;
      
    @Column(name = "image", nullable = false)
    private String image;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public void setCreator(User creator) {
        this.creator = creator;
    }
    public User getCreator() {
        return creator;
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

    public Long getCreator_Id(){return creator.getId();}
}
