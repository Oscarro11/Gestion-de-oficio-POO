package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKGUESTS")
public class WorkGuest extends Worker{
    
    @Column(name = "IdentificationCode", nullable = false)
    private String identification_code;

    @Column(name = "GuestName", nullable = false)
    private String guestname;

    public String getIdentification_code() {
        return identification_code;
    }
    public void setIdentification_code(String identification_code) {
        this.identification_code = identification_code;
    }

    public String getGuestname() {
        return guestname;
    }
    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }
}
