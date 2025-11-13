package com.example.demo.service;

import com.example.demo.model.AvailableReward;
import com.example.demo.model.Reward;
import com.example.demo.model.Worker;
import com.example.demo.repository.AvailableRewardRepository;
import com.example.demo.repository.RewardRepository;
import com.example.demo.repository.WorkGroupRepository;
import com.example.demo.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableRewardService {
    private final AvailableRewardRepository availableRewardRepository;
    private final RewardRepository rewardRepository;
    private final WorkGroupRepository workGroupRepository;
    private final WorkerRepository workerRepository;

    public AvailableRewardService(AvailableRewardRepository availableRewardRepository, RewardRepository rewardRepository, WorkGroupRepository workGroupRepository, WorkerRepository workerRepository){
        this.availableRewardRepository = availableRewardRepository;
        this.rewardRepository = rewardRepository;
        this.workGroupRepository = workGroupRepository;
        this.workerRepository = workerRepository;
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
                availableRewardRepository.save(availableReward);
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

    public boolean reclaimAvailableReward(Long reward_id, Long worker_id) {
        AvailableReward availableReward = availableRewardRepository.findById(worker_id).get();
        Worker worker = workerRepository.findById(worker_id).get();

        if (availableReward.getPoints_cost() > worker.getRewardPoints()) {
            return false;
        }
        else{
            worker.substractRewardPoints(availableReward.getPoints_cost());
            workerRepository.save(worker);
            availableReward.removeStocks(1);
            availableRewardRepository.save(availableReward);

            return true;
        }
        
    }

    public void checkAvailableRewardStocks(Long reward_id){
        AvailableReward availableReward = availableRewardRepository.findById(reward_id).get();
        if (availableReward.getStocks() == 0) {
            availableRewardRepository.deleteById(reward_id);
        }
    }
}
