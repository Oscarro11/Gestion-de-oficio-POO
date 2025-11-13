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

import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    public ResponseEntity<Boolean> createWorkUser(@RequestBody WorkUserRequestDTO workUserRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(workUserService.createWorkUser(cookiesService.getActiveUserId(activeSession), cookiesService.getActiveWorkGroupId(activeSession), workUserRequestDTO.getUser_name()));
    }

    @PostMapping("/unvalidatedCreateWorkUser")
    public ResponseEntity<WorkUserResponseDTO> unvalidatedCreateWorkUser(@RequestBody WorkUserRequestDTO workUserRequestDTO, HttpSession activeSession){ 
        WorkUser workUser = workUserService.saveWorkUser(
        cookiesService.getActiveUserId(activeSession),
        cookiesService.getActiveWorkGroupId(activeSession),
        workUserRequestDTO.getUser_name());
    
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
    public ResponseEntity<Boolean> createWorkGuest(@RequestBody WorkGuestRequestDTO workGuestRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(workGuestService.createWorkGuest(cookiesService.getActiveUserId(activeSession), cookiesService.getActiveWorkGroupId(activeSession), workGuestRequestDTO.getName()));
    }

    @PostMapping("/unvalidatedCreateWorkGuest")
    public ResponseEntity<WorkGuestResponseDTO> unvalidatedCreateWorkGuest(@RequestBody WorkGuestRequestDTO workGuestRequestDTO, HttpSession activeSession){
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

    @PostMapping("/deleteWorkers")
    public ResponseEntity<Boolean> deleteWorkers(@RequestBody List<Long> ids) {
        for (Long id : ids) {
            workerService.deleteWorker(id);
        }
        
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getActiveWorker")
    public ResponseEntity<WorkerResponseDTO> getActiveWorker(HttpSession activeSession) {
        Worker worker = workerService.getWorkerById(cookiesService.getActiveWorkerId(activeSession));
        WorkerResponseDTO dto = new WorkerResponseDTO();

        dto.setCreator_id(worker.getCreator_Id());
        dto.setId(worker.getId());
        dto.setReward_points_quantity(worker.getRewardPoints());
        dto.setWorker_name(worker.getName());
        dto.setWorkGroup_id(worker.getWorkGroup_Id());
        
        Class<?> temp = Hibernate.getClass(worker);

        switch (temp.getSimpleName()) {
            case "WorkUser":
                dto.setWorker_type(1);
                break;

            case "WorkGuest":
                dto.setWorker_type(2);
                break;
        
            default:
                break;
        }

        return ResponseEntity.ok(dto);
    }
    
    @PutMapping("/setActiveWorkerFromUser")
    public void setActiveWorkerFromUser(HttpSession activeSession) {
        Long workerId = workerService.getActiveWorkerIdFromUser(cookiesService.getActiveWorkGroupId(activeSession), cookiesService.getActiveUserId(activeSession));
        cookiesService.setActiveWorkerId(activeSession, workerId);
    }

    @PostMapping("/setActiveWorkerFromGuest")
    public ResponseEntity<Boolean> setActiveWorkerFromGuest(@RequestBody String identificationCode, HttpSession activeSession) {
        WorkGuest workGuest = workGuestService.getWorkGuestByCode(identificationCode);

        if (workGuest == null) {
            return ResponseEntity.ok(false);
        }
        else{
            cookiesService.setActiveWorkerId(activeSession, workGuest.getId());
            cookiesService.setActiveWorkGroupId(activeSession, workGuest.getWorkGroup_Id());
            return ResponseEntity.ok(true);
        }
    }
}
