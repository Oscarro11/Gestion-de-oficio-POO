package com.example.demo.controller;

import com.example.demo.model.AssignedTask;
import com.example.demo.dto.AssignedTaskRequestDTO;
import com.example.demo.dto.AssignedTaskResponseDTO;
import com.example.demo.service.AssignedTaskService;
import com.example.demo.service.CookiesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("api/assignedTasks")
public class AssignedTaskController {
    private final AssignedTaskService assignedTaskService;
    private final CookiesService cookiesService;

    public AssignedTaskController(AssignedTaskService assignedTaskService, CookiesService cookiesService){
        this.assignedTaskService = assignedTaskService;
        this.cookiesService = cookiesService;
    }

    @PostMapping("/createAssignedTask")
    public ResponseEntity<Boolean> createAssignedTask(@RequestBody AssignedTaskRequestDTO assignedTaskRequestDTO) {
        return ResponseEntity.ok(assignedTaskService.createAssignedTask(
            assignedTaskRequestDTO.getReference_Task_id(), 
            assignedTaskRequestDTO.getReward_points(), 
            assignedTaskRequestDTO.getStartline(),
            assignedTaskRequestDTO.getWorker_id(),
            assignedTaskRequestDTO.getName()));
    }
    
    @GetMapping("/getAssignedTasksByWorkerId")
    public ResponseEntity<List<AssignedTaskResponseDTO>> getAssignedTasksByWorkerId(@RequestBody long worker_id) {
        List<AssignedTask> assignedTasks = assignedTaskService.getAssignedTasksByWorkerId(worker_id); 
        return ResponseEntity.ok(convertToDTOs(assignedTasks));
    }

    @GetMapping("/getActiveWorkerAssignedTasks")
    public ResponseEntity<List<AssignedTaskResponseDTO>> getActiveWorkerAssignedTasks(HttpSession activeSession) {
        List<AssignedTask> assignedTasks = assignedTaskService.getAssignedTasksByWorkerId(cookiesService.getActiveWorkerId(activeSession)); 
        return ResponseEntity.ok(convertToDTOs(assignedTasks));
    }

    @GetMapping("/getActiveWorkGroupAssignedTasks")
    public ResponseEntity<List<AssignedTaskResponseDTO>> getActiveWorkGroupAssignedTasks(HttpSession activeSession) {
        List<AssignedTask> assignedTasks = assignedTaskService.getAssignedTasksByWorkGroupId(cookiesService.getActiveWorkGroupId(activeSession)); 
        return ResponseEntity.ok(convertToDTOs(assignedTasks));
    }
    

    private List<AssignedTaskResponseDTO> convertToDTOs(List<AssignedTask> assignedTasks) {
        List<AssignedTaskResponseDTO> dtos = new ArrayList<>();

        for (AssignedTask assignedTask : assignedTasks) {
            AssignedTaskResponseDTO dto = new AssignedTaskResponseDTO();
            dto.setId(assignedTask.getId());
            dto.setEndline(assignedTask.getEnd_time());
            dto.setReference_id(assignedTask.getReference_Id());
            dto.setReward_points(assignedTask.getReward_points());
            dto.setStartline(assignedTask.getAssign_time());
            dto.setStatus(assignedTask.getStatus());
            dto.setWorker_id(assignedTask.getWorker_Id());
            dto.setName(assignedTask.getName());

            dtos.add(dto);
        }

        return dtos;
    }

    @PostMapping("/changeAssignedTaskStatus")
    public String changeAssignedTaskStatus(@RequestBody long assignedTask_id, @RequestBody int new_status){
        return assignedTaskService.changeAssignedTaskStatus(assignedTask_id, new_status);
    }
}
