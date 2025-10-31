package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKGUESTS")
public class WorkGuest extends Worker{
    
    @Column(name = "identificationCode", nullable = false)
    private String identificationCode;

    @Column(name = "name", nullable = false)
    private String name;

    public String getIdentificationCode() {
        return identificationCode;
    }
    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
