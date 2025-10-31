package com.example.demo.repository;

import com.example.demo.model.WorkGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkGroupRepository extends JpaRepository<WorkGroup, Long>{ 

}
