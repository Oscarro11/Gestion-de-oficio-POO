package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.List; 
  
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "WORKERS")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    protected User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workGroup_id", nullable = false)
    protected WorkGroup workGroup;

    @Column(name = "rewardPoints", nullable = false)
    protected int rewardPoints = 0;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    protected List<AssignedTask> assignedTasks;

    public Long getId() {
        return id;
    }

    public User getCreator() {
        return creator;
    }
    public void setCreator(User creator) {
        this.creator = creator;
    }

    public WorkGroup getWorkGroup() {
        return workGroup;
    }
    public void setWorkGroup(WorkGroup workGroup) {
        this.workGroup = workGroup;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
    public void addRewardPoints(int rewardPoints) {
        this.rewardPoints += rewardPoints;
    }
    public void substractRewardPoints(int rewardPoints){
        this.rewardPoints -= rewardPoints;
    }
    
    public String getName(){return null;}
    public Long getCreator_Id(){return creator.getId();}
    public Long getWorkGroup_Id(){return workGroup.getId();}
}
