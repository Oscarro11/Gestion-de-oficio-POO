package com.example.demo.model;

import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Inheritance;
//import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKUSERS")
public class WorkUser extends Worker{
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkUserReference", nullable = false)
    private User workUser;

    public User getWork_user() {
        return workUser;
    }
    public void setWork_user(User workUser) {
        this.workUser = workUser;
    }

}
