package com.example.demo.controller;

import com.example.demo.model.WorkGroup;
import com.example.demo.model.User;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.dto.WorkGroupRequestDTO;
import com.example.demo.dto.WorkGroupResponseDTO;
import com.example.demo.service.CookiesService;
import com.example.demo.service.WorkGroupService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/workGroups")
public class WorkGroupController {
    private final WorkGroupService workGroupService;
    private final CookiesService cookiesService;
    private final UserService userService;

    public WorkGroupController(WorkGroupService workGroupService, CookiesService cookiesService, UserService userService){
        this.workGroupService = workGroupService;
        this.userService = userService;
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
    public ResponseEntity<WorkGroupResponseDTO> createUnvalidatedWorkGroup(@RequestBody WorkGroupRequestDTO workGroupRequestDTO) {
        WorkGroup workGroup = workGroupService.saveUserWorkGroup((long) 1, workGroupRequestDTO.getWorkGroupName());
        
        WorkGroupResponseDTO dto = new WorkGroupResponseDTO();
        dto.setWorkgroup_name(workGroup.getName());
        dto.setAdministrator_id(workGroup.getAdministrator_Id());
        dto.setId(workGroup.getId());

        return ResponseEntity.ok(dto);
    }
    
    
    @PostMapping("/createWorkGroup")
    public ResponseEntity<Boolean> createWorkGroup(@RequestBody String newWorkGroupName, HttpSession activeSession) {
        List<WorkGroup> workGroups = workGroupService.getUserWorkGroups(cookiesService.getActiveUserId(activeSession));
        boolean usedName = false;

        for (WorkGroup workGroup : workGroups) {
            if (workGroup.getName().equals(newWorkGroupName)) {
                usedName = true;
                break;
            }    
        }

        if (usedName) {
            return ResponseEntity.ok(false);
        } 
        else {
            WorkGroup workGroup = workGroupService.saveUserWorkGroup(cookiesService.getActiveUserId(activeSession), newWorkGroupName);
            cookiesService.setActiveWorkGroupId(activeSession, workGroup.getId());

            return ResponseEntity.ok(workGroup != null);
        }
    }

    @GetMapping("/getUnusedUsers")
    public ResponseEntity<List<UserResponseDTO>> getUnusedUsers(HttpSession activeSession) {
        List<User> users = userService.getUnusedUsersInWorkGroup(cookiesService.getActiveWorkGroupId(activeSession), cookiesService.getActiveUserId(activeSession));
        List<UserResponseDTO> dtos = new ArrayList<UserResponseDTO>();

        for (User user : users) {
            UserResponseDTO dto = new UserResponseDTO();

            dto.setEmail(user.getEmail());
            dto.setId(user.getId());
            dto.setPassword(user.getPassword());
            dto.setUsername(user.getUsername());

            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }
    
    @GetMapping("/getWorkerWorkGroups")
    public ResponseEntity<List<WorkGroupResponseDTO>> getWorkerWorkGroups(HttpSession activeSession) {
        List<WorkGroup> workGroups = workGroupService.getWorkerWorkGroups(cookiesService.getActiveUserId(activeSession));
        List<WorkGroupResponseDTO> dtos = new ArrayList<WorkGroupResponseDTO>();

        for (WorkGroup workGroup: workGroups) {
            WorkGroupResponseDTO dto = new WorkGroupResponseDTO();

            dto.setId(workGroup.getId());
            dto.setAdministrator_id(workGroup.getAdministrator_Id());
            dto.setWorkgroup_name(workGroup.getName());

            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }
    
}
