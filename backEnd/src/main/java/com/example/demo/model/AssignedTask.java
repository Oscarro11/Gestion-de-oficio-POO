package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ASSIGNED_TASKS")
public class AssignedTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task reference;

    @Column(name = "Points", nullable = false)
    private int reward_points = 0;

    @Column(name = "Startline", nullable = false )
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    private LocalTime assign_time;
    
    @Column(name = "Deadline", nullable = false)
    @JsonFormat(pattern = "dd-MM-YYYY HH:mm")
    private LocalTime end_time;

    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;

    @Column(name = "Status_code")
    private int status = 0;

    public LocalTime getAssign_time() {
        return assign_time;
    }
    public void setAssign_time(LocalTime assign_time) {
        this.assign_time = assign_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }
    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Task getReference() {
        return reference;
    }
    public void setReference(Task reference) {
        this.reference = reference;
    }

    public int getReward_points() {
        return reward_points;
    }
    public void setReward_points(int reward_points) {
        this.reward_points = reward_points;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
