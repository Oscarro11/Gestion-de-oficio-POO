package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "AVAILABLE_REWARDS")
public class AvailableReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reward_id", nullable = false)
    private Reward reference;

    @ManyToOne
    @JoinColumn(name = "workgroup_id", nullable = false)
    private WorkGroup source;

    @Column(name = "points_cost", nullable = false)
    private int points_cost = 0;

    @Column(name = "stocks", nullable = false)
    private int stocks;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints_cost() {
        return points_cost;
    }
    public void setPoints_cost(int points_cost) {
        this.points_cost = points_cost;
    }

    public Reward getReference() {
        return reference;
    }
    public void setReference(Reward reference) {
        this.reference = reference;
    }

    public int getStocks() {
        return stocks;
    }
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public WorkGroup getSource() {
        return source;
    }
    public void setSource(WorkGroup source) {
        this.source = source;
    }

    public Long getSource_Id(){return source.getId();}
}