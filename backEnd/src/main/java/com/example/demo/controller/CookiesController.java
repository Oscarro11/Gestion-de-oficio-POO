package com.example.demo.controller;

import com.example.demo.service.CookiesService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/cookies")
public class CookiesController {
    private final CookiesService cookiesService;
    
    public CookiesController(CookiesService cookiesService){
        this.cookiesService = cookiesService;
    }

    //For development testing purposes only
    @PostMapping("/setActiveUserId")
    public void setActiveUserId(@RequestBody Long id, HttpSession activeSession) {
        cookiesService.setActiveUserId(activeSession, id);
    }

    @GetMapping("/getActiveUserId")
    public long getActiveUserId(HttpSession activeSession) {
        return cookiesService.getActiveUserId(activeSession);
    }
    

    @PostMapping("/setActiveWorkGroupId")
    public void setActiveWorkGroupId(@RequestBody Long id, HttpSession activeSession) {
        cookiesService.setActiveWorkGroupId(activeSession, id);
    }

    @GetMapping("/getActiveWorkGroupId")
    public long getActiveWorkGroupId(HttpSession activeSession) {
        return cookiesService.getActiveWorkGroupId(activeSession);
    }
    

    @PostMapping("/setActiveTaskId")
    public void setActiveTaskId(@RequestBody Long id, HttpSession activeSession) {
        cookiesService.setActiveTaskId(activeSession, id);
    }

    @GetMapping("/getActiveTaskId")
    public long getActiveTaskId(HttpSession activeSession) {
        return cookiesService.getActiveTaskId(activeSession);
    }


    @PostMapping("/setActiveRewardId")
    public void setActiveRewardId(@RequestBody Long id, HttpSession activeSession) {
        cookiesService.setActiveRewardId(activeSession, id);
    }

    @GetMapping("/getActiveRewardId")   
    public long getActiveRewardId(HttpSession activeSession) {
        return cookiesService.getActiveRewardId(activeSession);
    }
    

    @PostMapping("/setActiveWorkerId")
    public void setActiveWorkerId(@RequestBody Long id, HttpSession activeSession) {
        cookiesService.setActiveWorkerId(activeSession, id);
    }

    @GetMapping("/getActiveWorkerId")
    public long getActiveWorkerId(HttpSession activeSession) {
        return cookiesService.getActiveWorkerId(activeSession);
    }
    
    
    //--------------------------------------------

    @PutMapping("/setDeleteTasksModeToFalse")
    public void setDeleteTasksModeToFalse(HttpSession activeSession) {
        cookiesService.setDeleteTasksModeToFalse(activeSession);
    }

    @PutMapping("/setDeleteWorkersModeToFalse")
    public void setDeleteWorkersModeToFalse(HttpSession activeSession) {
        cookiesService.setDeleteWorkersModeToFalse(activeSession);
    }

    @PutMapping("/setDeleteRewardsModeToFalse")
    public void setDeleteRewardsModeToFalse(HttpSession activeSession) {
        cookiesService.setDeleteRewardsModeToFalse(activeSession);
    }


    @PutMapping("/switchDeleteTasksMode")
    public ResponseEntity<Boolean> switchDeleteTasksMode(HttpSession activeSession) {
        return ResponseEntity.ok(cookiesService.switchDeleteTasksMode(activeSession));
    }
    
    @PutMapping("/switchDeleteWorkersMode")
    public ResponseEntity<Boolean> switchDeleteWorkerMode(HttpSession activeSession) {
        return ResponseEntity.ok(cookiesService.switchDeleteWorkersMode(activeSession));
    }

    @PutMapping("/switchDeleteRewardsMode")
    public ResponseEntity<Boolean> switchDeleteRewardsMode(HttpSession activeSession) {
        return ResponseEntity.ok(cookiesService.switchDeleteRewardsMode(activeSession));
    }

    @GetMapping("/getDeleteTasksMode")
    public ResponseEntity<Boolean> getDeleteTasksMode(HttpSession activeSession) {
        return ResponseEntity.ok(cookiesService.getDeleteTasksMode(activeSession));
    }

    @GetMapping("/getDeleteWorkersMode")
    public ResponseEntity<Boolean> getDeleteWorkersMode(HttpSession activeSession) {
        return ResponseEntity.ok(cookiesService.getDeleteWorkersMode(activeSession));
    }

    @GetMapping("/getDeleteRewardsMode")
    public ResponseEntity<Boolean> getDeleteRewardsMode(HttpSession activeSession) {
        return ResponseEntity.ok(cookiesService.getDeleteRewardsMode(activeSession));
    }
}
