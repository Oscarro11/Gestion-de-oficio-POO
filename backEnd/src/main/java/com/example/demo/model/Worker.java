package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public abstract class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @ManyToOne
    @JoinColumn(name = "workGroup_id", nullable = false)
    private WorkGroup workGroup;

    @Column(name = "rewardPoints", nullable = false)
    private int rewardPoints = 0;

    @OneToMany(mappedBy = "worker")
    private List<AssignedTask> assignedTasks;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<AssignedTask> getAssignedTasks() {
        return assignedTasks;
    }
    public void setAssignedTasks(List<AssignedTask> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public int getReward_points() {
        return rewardPoints;
    }
    public void setReward_points(int reward_points) {
        this.rewardPoints = reward_points;
    }
}
