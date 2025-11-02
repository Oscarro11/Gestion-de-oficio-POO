package com.example.demo.controller;

import com.example.demo.model.WorkGroup;
import com.example.demo.dto.WorkGroupRequestDTO;
import com.example.demo.dto.WorkGroupResponseDTO;
import com.example.demo.service.CookiesService;
import com.example.demo.service.WorkGroupService;
//import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/workGroups")
public class WorkGroupController {
    private final WorkGroupService workGroupService;
    private final CookiesService cookiesService;

    public WorkGroupController(WorkGroupService workGroupService, CookiesService cookiesService){
        this.workGroupService = workGroupService;
        this.cookiesService = cookiesService;
    }

    @GetMapping("/getUserWorkGroups")
    public ResponseEntity<List<WorkGroupResponseDTO>> getActiveUserWorkGroup(HttpSession activeSession) {
        List<WorkGroup> user_workGroups = workGroupService.getUserWorkGroups(cookiesService.getActiveUserId(activeSession));
        List<WorkGroupResponseDTO> user_DTO_workGroups = new ArrayList<WorkGroupResponseDTO>();

        for (WorkGroup workGroup : user_workGroups) {
            WorkGroupResponseDTO dto = new WorkGroupResponseDTO();
            dto.setWorkgroup_name(workGroup.getName());
            dto.setAdministrator_id(workGroup.getAdministrator_Id());
            dto.setId(workGroup.getId());
            user_DTO_workGroups.add(dto);
        }

        return ResponseEntity.ok(user_DTO_workGroups);
    }

    @PostMapping("/unvalidatedCreateWorkGroup")
    public ResponseEntity<WorkGroup> createUnvalidatedWorkGroup(@RequestBody WorkGroupRequestDTO workGroupRequestDTO) {
        return ResponseEntity.ok(workGroupService.saveUserWorkGroup((long) 1, workGroupRequestDTO.getWorkGroupName()));
    }
    
    
    @PostMapping("/createWorkGroup")
    public ResponseEntity<Boolean> createWorkGroup(@RequestBody WorkGroupRequestDTO workGroupRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(workGroupService.createUserWorkGroup(cookiesService.getActiveUserId(activeSession), workGroupRequestDTO.getWorkGroupName()));
    }

}
