package com.example.demo.repository;

import com.example.demo.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{
    
    List<Worker> findByCreator_Id(Long creator_Id);
    List<Worker> findByWorkGroup_Id(Long workGroup_Id);

}
