package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taskname", nullable = false)
    private String taskname;

    @Column(name = "description")
    private String description;

    @Column(name = "duration", nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime duration;

    @Column(name = "videoReference")
    private String videoReference;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getTaskname(){return taskname;}
    public void setTaskname(String name){this.taskname = name;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public LocalTime getDuration(){return duration;}
    public void setDuration(LocalTime duration){this.duration = duration;}

    public String getVideoReference(){return videoReference;}
    public void setVideoReference(String videoReference){this.videoReference = videoReference;} 

    public void setCreator(User creator) {
        this.creator = creator;
    }
    public User getCreator() {
        return creator;
    }

    public Long getCreator_Id(){return creator.getId();};

}
