package com.example.demo.repository;

import com.example.demo.model.AvailableReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvailableRewardRepository extends JpaRepository<AvailableReward, Long>{
    
    List<AvailableReward> findBySource_Id(Long source_Id);
    List<AvailableReward> findByReference_Id(Long reference_Id);

}
