package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.List;
 

@Entity
@Table(name = "WORKGROUPS")
public class WorkGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User administrator;
    
    @OneToMany(mappedBy = "workGroup")
    private List<Worker> workers;
    
    @OneToMany(mappedBy = "source")
    private List<AvailableReward> rewardsList;
    

    public void setAdministrator(User administrator) {
        this.administrator = administrator;
    }
    public User getAdministrator() {
        return administrator;
    }

    public void setRewardsList(List<AvailableReward> rewardsList) {
        this.rewardsList = rewardsList;
    }
    public List<AvailableReward> getRewardsList() {
        return rewardsList;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
    public List<Worker> getWorkers() {
        return workers;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
