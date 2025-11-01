package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User administrator;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "workGroup", cascade = CascadeType.ALL)
    private List<Worker> workers;
    
    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private List<AvailableReward> rewardsList;
    


    public void setAdministrator(User administrator) {
        this.administrator = administrator;
    }
    public User getAdministrator() {
        return administrator;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getAdministrator_Id() {return administrator.getId();}
}
