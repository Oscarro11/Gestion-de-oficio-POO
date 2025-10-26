package com.example.demo.service;

import com.example.demo.model.Reward;
import com.example.demo.repository.RewardRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {
    private final RewardRepository rewardRepository;
    private final UserRepository userRepository;

    public RewardService(RewardRepository rewardRepository, UserRepository userRepository){
        this.rewardRepository = rewardRepository;
        this.userRepository = userRepository;
    }

    public List<Reward> getAllRewards(){
        return rewardRepository.findAll();
    }

    public Reward getRewardById(Long id){
        return rewardRepository.getReferenceById(id);
    }

    public List<Reward> getRewardsByUserId(Long user_id){
        return rewardRepository.findByCreator_Id(user_id);
    }

    public boolean createUserReward(String rewardname, String rewardDescription, String rewardImage, Long creator_id){
        List<Reward> rewards = rewardRepository.findByCreator_Id(creator_id);
        boolean usedName = false;

        for (Reward reward: rewards) {
            if (reward.getRewardName().equals(rewardname)) {
                usedName = true;
                break;
            }
        }

        if (usedName) {
            return false;
        }
        else{
            saveUserReward(rewardname, rewardDescription, rewardImage, creator_id);
            return true;
        }
    }

    public Reward saveUserReward(String rewardname, String rewardDescription, String rewardImage, Long creator_id){
        Reward reward = new Reward();
        reward.setRewardName(rewardname);
        reward.setDescription(rewardDescription);
        reward.setImage(rewardImage);
        reward.setRewardCreator(userRepository.getReferenceById(creator_id));

        return rewardRepository.save(reward);
    }

    public void deleteUserReward(long id){
        rewardRepository.deleteById(id);
    }
    
}
