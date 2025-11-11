package com.example.demo.service;

import com.example.demo.model.AvailableReward;
import com.example.demo.model.Reward;
import com.example.demo.repository.AvailableRewardRepository;
import com.example.demo.repository.RewardRepository;
import com.example.demo.repository.WorkGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableRewardService {
    private final AvailableRewardRepository availableRewardRepository;
    private final RewardRepository rewardRepository;
    private final WorkGroupRepository workGroupRepository;

    public AvailableRewardService(AvailableRewardRepository availableRewardRepository, RewardRepository rewardRepository, WorkGroupRepository workGroupRepository){
        this.availableRewardRepository = availableRewardRepository;
        this.rewardRepository = rewardRepository;
        this.workGroupRepository = workGroupRepository;
    }
    
    public List<AvailableReward> getAllAvailableRewards(){
        return availableRewardRepository.findAll();
    }

    public AvailableReward getAvailableRewardById(Long id){
        return availableRewardRepository.getReferenceById(id);
    }

    public List<AvailableReward> getAvailableRewardByWorkGroupId(Long workGroup_id) {
        return availableRewardRepository.findBySource_Id(workGroup_id);
    }

    public boolean createAvailableReward(Long reference_id, Long source_id, int points_value, int stocks_quantity){
        List<AvailableReward> availableRewards = availableRewardRepository.findBySource_Id(source_id);
        boolean updatedAvailableReward = false;

        for (AvailableReward availableReward : availableRewards) {
            if (availableReward.getReference_Id() == reference_id && availableReward.getPoints_cost() == points_value) {
                availableReward.addStocks(stocks_quantity);
                updatedAvailableReward = true;
                break;
            }
        }

        if (updatedAvailableReward) {
            return false;
        }
        else{
            saveAvailableReward(reference_id, source_id, points_value, stocks_quantity);
            return true;
        }
    }

    public AvailableReward saveAvailableReward(Long reference_id, Long source_id, int points_value, int stocks_quantity) {
        AvailableReward availableReward = new AvailableReward();
        availableReward.setReference(rewardRepository.getReferenceById(reference_id));
        availableReward.setPoints_cost(points_value);
        availableReward.setSource(workGroupRepository.getReferenceById(source_id));
        availableReward.setStocks(stocks_quantity);

        return availableRewardRepository.save(availableReward);
    }
}
