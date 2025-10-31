package com.example.demo.repository;

import com.example.demo.model.WorkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkUserRepository extends JpaRepository<WorkUser, Long>{
    
    List<WorkUser> findByReference_Id(Long reference_Id);

}
