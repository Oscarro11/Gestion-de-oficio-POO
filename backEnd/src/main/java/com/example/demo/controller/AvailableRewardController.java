package com.example.demo.controller;

import com.example.demo.dto.AvailableRewardRequestDTO;
import com.example.demo.dto.AvailableRewardResponseDTO;
import com.example.demo.model.AvailableReward;
import com.example.demo.service.AvailableRewardService;
import com.example.demo.service.CookiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/availableRewards")
public class AvailableRewardController {
    private final AvailableRewardService availableRewardService;
    private final CookiesService cookiesService;

    public AvailableRewardController(AvailableRewardService availableRewardService, CookiesService cookiesService) {
        this.availableRewardService = availableRewardService;
        this.cookiesService = cookiesService;
    }

    @GetMapping("/getActiveWorkGroupAvailableRewards")
    public ResponseEntity<List<AvailableRewardResponseDTO>> getActiveWorkGroupAvailableRewards(HttpSession activeSession) {
        List<AvailableReward> availableRewards = availableRewardService.getAvailableRewardByWorkGroupId(cookiesService.getActiveWorkGroupId(activeSession));
        List<AvailableRewardResponseDTO> dtos = new ArrayList<AvailableRewardResponseDTO>();

        for (AvailableReward availableReward : availableRewards) {
            AvailableRewardResponseDTO dto = new AvailableRewardResponseDTO();

            dto.setId(availableReward.getId());
            dto.setPoints_value(availableReward.getPoints_cost());
            dto.setReference_id(availableReward.getReference_Id());
            dto.setSource_id(availableReward.getSource_Id());
            dto.setStocks_quantity(availableReward.getStocks());

            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }
    
    @PostMapping("/createAvailableReward")
    public ResponseEntity<Boolean> postMethodName(@RequestBody AvailableRewardRequestDTO availableRewardRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(availableRewardService.createAvailableReward(availableRewardRequestDTO.getReference_id(), cookiesService.getActiveWorkGroupId(activeSession), availableRewardRequestDTO.getPoints_value(), availableRewardRequestDTO.getStocks_quantity()));
    }
}
