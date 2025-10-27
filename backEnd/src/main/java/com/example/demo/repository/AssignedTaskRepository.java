package com.example.demo.repository;

import com.example.demo.model.AssignedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long>{

    List<AssignedTask> findByWorker_Id(Long worker_Id);
    List<AssignedTask> findByReference_Id(Long reference_Id);

}
