package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKGUESTS")
public class WorkGuest extends Worker{
    
    @Column(name = "identificationCode")
    private String identificationCode;

    @Column(name = "name", nullable = false)
    private String name;

    
    @PostPersist
    private void generateIdentificationCode() {
        this.identificationCode = String.format("%06d", (this.id * 73573 + 91381) % 1_000_000);
    }


    public String getIdentificationCode() {
        return identificationCode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
