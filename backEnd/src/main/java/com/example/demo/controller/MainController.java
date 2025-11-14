package com.example.demo.controller;

import com.example.demo.dto.UserResponseDTO;
import com.example.demo.dto.AssignedTaskResponseDTO;
import com.example.demo.model.User;
import com.example.demo.model.WorkUser;
import com.example.demo.model.AssignedTask;
import com.example.demo.service.UserService;
import com.example.demo.service.CookiesService;
import com.example.demo.service.WorkUserService;
import com.example.demo.service.AssignedTaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/Main")
public class MainController {   
    private final UserService userService;
    private final CookiesService cookiesService;
    private final WorkUserService workUserService;
    private final AssignedTaskService assignedTaskService;

    public MainController(UserService userService, CookiesService cookiesService, WorkUserService workUserService, AssignedTaskService assignedTaskService){
        this.userService = userService;
        this.cookiesService = cookiesService;
        this.workUserService = workUserService;
        this.assignedTaskService = assignedTaskService;
    }

    @GetMapping("/getActiveUserName")
    public ResponseEntity<String> getActiveUserName(HttpSession activeSession){
        UserResponseDTO dto = getActiveUser(activeSession).getBody();
        return ResponseEntity.ok(dto.getUsername());
    }

    @GetMapping("/getActiveUser")
    public ResponseEntity<UserResponseDTO> getActiveUser(HttpSession activeSession){

        User user =  userService.getUserById(cookiesService.getActiveUserId(activeSession));
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return ResponseEntity.ok(dto);
    }   

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserResponseDTO>> listUsers() {
        List<User> user = userService.getAllUsers();
        List<UserResponseDTO> newDtos = new ArrayList<UserResponseDTO>();

        for (User u : user){
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(u.getId());
            dto.setUsername(u.getUsername());
            dto.setEmail(u.getEmail());
            dto.setPassword(u.getPassword());
            newDtos.add(dto);
        }

        return ResponseEntity.ok(newDtos);
    }
    
    @GetMapping("/getUserAssignedTasks")
    public ResponseEntity<List<AssignedTaskResponseDTO>> getUserAssignedTasks(HttpSession activeSession) {

        List<WorkUser> workUsers = workUserService.getWorkUserByReferenceId(cookiesService.getActiveUserId(activeSession));
        List<AssignedTaskResponseDTO> dtos = new ArrayList<AssignedTaskResponseDTO>();

        for (WorkUser workUser: workUsers) {
            List<AssignedTask> assignedTasks = assignedTaskService.getAssignedTasksByWorkerId(workUser.getId());
            for (AssignedTask assignedTask : assignedTasks) {
                
                AssignedTaskResponseDTO dto = new AssignedTaskResponseDTO();
                dto.setId(assignedTask.getId());
                dto.setName(assignedTask.getName());
                dto.setEndline(assignedTask.getEnd_time());
                dto.setReference_id(assignedTask.getReference_Id());
                dto.setReward_points(assignedTask.getReward_points());
                dto.setStartline(assignedTask.getAssign_time());
                dto.setStatus(assignedTask.getStatus());
                dto.setWorker_id(assignedTask.getWorker_Id());

                dtos.add(dto);
            }
        }

        return ResponseEntity.ok(dtos);
    }
}
