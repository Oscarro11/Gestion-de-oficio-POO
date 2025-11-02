package com.example.demo.controller;

import com.example.demo.model.Worker;
import com.example.demo.model.WorkUser;
import com.example.demo.model.WorkGuest;
import com.example.demo.dto.WorkerResponseDTO;
import com.example.demo.dto.WorkUserResponseDTO;
import com.example.demo.dto.WorkUserRequestDTO;
import com.example.demo.dto.WorkGuestResponseDTO;
import com.example.demo.dto.WorkGuestRequestDTO;
import com.example.demo.service.WorkerService;
import com.example.demo.service.WorkUserService;
import com.example.demo.service.WorkGuestService;
import com.example.demo.service.CookiesService;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/workers")
public class WorkerController {
    private final WorkerService workerService;
    private final WorkUserService workUserService;
    private final WorkGuestService workGuestService;
    private final CookiesService cookiesService;

    public WorkerController(WorkerService workerService, WorkUserService workUserService, WorkGuestService workGuestService, CookiesService cookiesService){
        this.workerService = workerService;
        this.workUserService = workUserService;
        this.workGuestService = workGuestService;
        this.cookiesService = cookiesService;
    }

    @PostMapping("/createWorkUser")
    public ResponseEntity<WorkUserResponseDTO> createWorkUser(@RequestBody WorkUserRequestDTO workUserRequestDTO, HttpSession activeSession){ 
        WorkUser workUser = workUserService.saveWorkUser(
            cookiesService.getActiveUserId(activeSession),
            cookiesService.getActiveWorkGroupId(activeSession),
            workUserRequestDTO.getReference_id());
        
        WorkUserResponseDTO dto = new WorkUserResponseDTO();
        dto.setId(workUser.getId());
        dto.setCreator_id(workUser.getCreator_Id());
        dto.setReward_points_quantity(workUser.getRewardPoints());
        dto.setWorkGroup_id(workUser.getWorkGroup_Id());
        dto.setReference_id(workUser.getReference_Id());

        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/getWorkersByWorkGroupId")
    public ResponseEntity<List<WorkerResponseDTO>> getWorkersByWorkGroupId(HttpSession activeSession) {
        List<Worker> workers = workerService.getWorkersByWorkGroupId(cookiesService.getActiveWorkGroupId(activeSession));
        List<WorkerResponseDTO> worker_DTOs = new ArrayList<WorkerResponseDTO>();

        for (Worker worker : workers) {
            WorkerResponseDTO dto = new WorkerResponseDTO();

            dto.setId(worker.getId());
            dto.setCreator_id(worker.getCreator_Id());
            dto.setReward_points_quantity(worker.getRewardPoints());
            dto.setWorkGroup_id(worker.getWorkGroup_Id());

            worker_DTOs.add(dto);
        }

        return ResponseEntity.ok(worker_DTOs);
    }
    

}
