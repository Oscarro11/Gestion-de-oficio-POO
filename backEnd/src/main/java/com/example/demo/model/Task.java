package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
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

    @Column(name = "Taskname", nullable = false)
    private String taskname;

    @Column(name = "Description")
    private String description;

    @Column(name = "Duration", nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime duration;

    @Column(name = "Video_reference")
    private String video_reference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator", nullable = false)
    private User creator;

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getTaskname(){return taskname;}
    public void setTaskname(String name){this.taskname = name;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public LocalTime getDuration(){return duration;}
    public void setDuration(LocalTime duration){this.duration = duration;}

    public String getVideoReference(){return video_reference;}
    public void setVideoReference(String video_reference){this.video_reference = video_reference;}

    //public User getCreator() {return creator;}
    public void setCreator(User creator) {this.creator = creator;}

    public Long getCreator_Id(){return creator.getId();}
}
