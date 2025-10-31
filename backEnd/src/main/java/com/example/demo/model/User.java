package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<Task>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Worker> workers;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private List<WorkGroup> workGroups;


    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
}
