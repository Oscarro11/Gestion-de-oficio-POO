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
import com.example.demo.service.UserService;
import com.example.demo.service.CookiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/workers")
public class WorkerController {
    private final WorkerService workerService;
    private final WorkUserService workUserService;
    private final WorkGuestService workGuestService;
    private final CookiesService cookiesService;
    private final UserService userService;

    public WorkerController(WorkerService workerService, WorkUserService workUserService, WorkGuestService workGuestService, CookiesService cookiesService, UserService userService){
        this.workerService = workerService;
        this.workUserService = workUserService;
        this.workGuestService = workGuestService;
        this.cookiesService = cookiesService;
        this.userService = userService;
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
        dto.setWorker_name(userService.getUserNameById(workUser.getReference_Id()));
        dto.setWorker_type(1);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/createWorkGuest")
    public ResponseEntity<WorkGuestResponseDTO> createWorkGuest(@RequestBody WorkGuestRequestDTO workGuestRequestDTO, HttpSession activeSession){
        WorkGuest newWorkGuest = workGuestService.saveWorkGuest(
            cookiesService.getActiveUserId(activeSession), 
            cookiesService.getActiveWorkGroupId(activeSession), 
            workGuestRequestDTO.getName());
        
        WorkGuestResponseDTO dto = new WorkGuestResponseDTO();
        dto.setCreator_id(newWorkGuest.getCreator_Id());
        dto.setIdentification_code(newWorkGuest.getIdentificationCode());
        dto.setWorker_name(newWorkGuest.getName());
        dto.setId(newWorkGuest.getId());
        dto.setReward_points_quantity(newWorkGuest.getRewardPoints());
        dto.setWorkGroup_id(newWorkGuest.getWorkGroup_Id());
        dto.setWorker_type(2);

        return ResponseEntity.ok(dto);
    }
    
    
    @GetMapping("/getActiveWorkGroupWorkers")
    public ResponseEntity<List<WorkerResponseDTO>> getWorkersByWorkGroupId(HttpSession activeSession) {
        List<Worker> workers = workerService.getWorkersByWorkGroupId(cookiesService.getActiveWorkGroupId(activeSession));
        List<WorkerResponseDTO> worker_DTOs = new ArrayList<WorkerResponseDTO>();

        for (Worker worker : workers) {
            WorkerResponseDTO dto = new WorkerResponseDTO();

            dto.setId(worker.getId());
            dto.setCreator_id(worker.getCreator_Id());
            dto.setReward_points_quantity(worker.getRewardPoints());
            dto.setWorkGroup_id(worker.getWorkGroup_Id());

            switch (worker) {
                case WorkUser workUser:
                    dto.setWorker_type(1);
                    dto.setWorker_name(userService.getUserNameById(workUser.getReference_Id()));
                    break;

                case WorkGuest workGuest:
                    dto.setWorker_type(2);
                    dto.setWorker_name(workGuest.getName());
                    break;
            
                default:
                    break;
            }

            worker_DTOs.add(dto);
        }

        return ResponseEntity.ok(worker_DTOs);
    }

}
