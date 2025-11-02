package com.example.demo.controller;

import com.example.demo.model.Reward;
import com.example.demo.dto.RewardRequestDTO;
import com.example.demo.dto.RewardResponseDTO;
import com.example.demo.service.RewardService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("api/rewards")
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService){
        this.rewardService = rewardService;
    }

    @PostMapping("/unvalidatedCreateReward")
    public ResponseEntity<RewardResponseDTO> createUnvalidatedReward(@RequestBody RewardRequestDTO rewardRequestDTO) {
        Reward reward = rewardService.saveUserReward(rewardRequestDTO.getRewardname(), rewardRequestDTO.getDescription(), rewardRequestDTO.getImage(), (long) 1);
        
        RewardResponseDTO dto = new RewardResponseDTO();
        dto.setCreator_id(reward.getCreator_Id());
        dto.setDescription(reward.getDescription());
        dto.setId(reward.getId());
        dto.setImage(reward.getImage());
        dto.setRewardname(reward.getRewardName());

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/createReward")
    public ResponseEntity<Boolean> createReward(@RequestBody RewardRequestDTO rewardRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(rewardService.createUserReward(rewardRequestDTO.getRewardname(), rewardRequestDTO.getDescription(), rewardRequestDTO.getImage(), (long) activeSession.getAttribute("activeUserId")));
    }

    @GetMapping("/getUserRewards")
    public ResponseEntity<List<RewardResponseDTO>> getUserRewards(HttpSession activeSession) {
        List<Reward> user_rewards = rewardService.getRewardsByUserId((long) activeSession.getAttribute("activeUserId"));
        List<RewardResponseDTO> user_DTO_rewards = new ArrayList<RewardResponseDTO>();
    
        for (Reward reward : user_rewards) {
            RewardResponseDTO dto = new RewardResponseDTO();
            dto.setRewardname(reward.getRewardName());
            dto.setDescription(reward.getDescription());
            dto.setCreator_id(reward.getCreator_Id());
            dto.setId(reward.getId());
            dto.setImage(reward.getImage());
            user_DTO_rewards.add(dto);
        }


        return ResponseEntity.ok(user_DTO_rewards);
    }
    
    @GetMapping("/getCurrentReward")
    public ResponseEntity<RewardResponseDTO> getCurrentReward(@RequestBody Long id) {
        return inspectRewardById(id);
    }

    @PostMapping("/deleteRewards")
    public ResponseEntity<Boolean> inspectTask(@RequestBody List<Long> ids , HttpSession activeSession) {
        for (Long id : ids) {
            rewardService.deleteUserReward(id);
        }
        
        return ResponseEntity.ok(true);
    }
    
    
    private ResponseEntity<RewardResponseDTO> inspectRewardById(long id){
        Reward reward = rewardService.getRewardById(id);
        RewardResponseDTO dto = new RewardResponseDTO();

        dto.setCreator_id(reward.getCreator_Id());
        dto.setId(reward.getId());
        dto.setDescription(reward.getDescription());
        dto.setImage(reward.getImage());
        dto.setRewardname(reward.getRewardName());
        return ResponseEntity.ok(dto);

    }

}
