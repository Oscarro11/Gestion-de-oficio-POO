package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.dto.TaskResponseDTO;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService, UserService userService){
        this.taskService = taskService;
    }

    @PostMapping("/unvalidatedCreateTask")
    public ResponseEntity<Task> createUnvalidatedTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.ok(taskService.saveUserTask(taskRequestDTO.getTaskname(), taskRequestDTO.getDescription(), taskRequestDTO.getDuration(), taskRequestDTO.getReference_video(), new Long(1)));
    }    

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequestDTO taskRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(taskService.saveUserTask(taskRequestDTO.getTaskname(), taskRequestDTO.getDescription(), taskRequestDTO.getDuration(), taskRequestDTO.getReference_video(), (long) activeSession.getAttribute("activeUserId")));
    }
    
    
    @GetMapping("/getUserTasks")
    public ResponseEntity<List<TaskResponseDTO>> getUserTasks(HttpSession activeSession) {
        List<Task> user_tasks = taskService.getTasksByUserID((long) activeSession.getAttribute("activeUserId"));
        List<TaskResponseDTO> user_DTO_tasks = new ArrayList<TaskResponseDTO>();
        
        for (Task task : user_tasks) {
            TaskResponseDTO dto = new TaskResponseDTO();
            dto.setTaskname(task.getTaskname());
            dto.setCreator_id(task.getCreator_Id());
            dto.setDescription(task.getDescription());
            dto.setDuration(task.getDuration());
            dto.setReference_video(task.getVideoReference());
            user_DTO_tasks.add(dto);
        }

        return ResponseEntity.ok(user_DTO_tasks);
    }
    
}
