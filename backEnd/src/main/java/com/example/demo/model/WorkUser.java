package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKUSERS")  
public class WorkUser extends Worker{
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User reference;

    public User getReference() {
        return reference;
    }
    public void setReference(User reference) {
        this.reference = reference;
    }

    public Long getReference_Id(){return reference.getId();}

}
