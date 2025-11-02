package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.dto.TaskResponseDTO;
import com.example.demo.service.TaskService;
import com.example.demo.service.CookiesService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;


  
@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final CookiesService cookiesService;
    
    public TaskController(TaskService taskService, CookiesService cookiesService){
        this.taskService = taskService;
        this.cookiesService = cookiesService;
    }

    @PostMapping("/unvalidatedCreateTask")
    public ResponseEntity<TaskResponseDTO> createUnvalidatedTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = taskService.saveUserTask(taskRequestDTO.getTaskname(), taskRequestDTO.getDescription(), taskRequestDTO.getDuration(), taskRequestDTO.getReferenceVideo(), (long) 1);
        
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setCreator_id(task.getCreator_Id());
        dto.setDescription(task.getDescription());
        dto.setDuration(task.getDuration());
        dto.setId(task.getId());
        dto.setReferenceVideo(task.getVideoReference());
        dto.setTaskname(task.getTaskname());

        return ResponseEntity.ok(dto);
    }    

    @PostMapping("/createTask")
    public ResponseEntity<Boolean> createTask(@RequestBody TaskRequestDTO taskRequestDTO, HttpSession activeSession) {      
        return ResponseEntity.ok(taskService.createUserTask(taskRequestDTO.getTaskname(), taskRequestDTO.getDescription(), taskRequestDTO.getDuration(), taskRequestDTO.getReferenceVideo(), cookiesService.getActiveUserId(activeSession)));
    }
    
    
    @GetMapping("/getUserTasks")
    public ResponseEntity<List<TaskResponseDTO>> getUserTasks(HttpSession activeSession) {
        List<Task> user_tasks = taskService.getTasksByUserID(cookiesService.getActiveUserId(activeSession));
        List<TaskResponseDTO> user_DTO_tasks = new ArrayList<TaskResponseDTO>();
        
        for (Task task : user_tasks) {
            TaskResponseDTO dto = new TaskResponseDTO();
            dto.setTaskname(task.getTaskname());
            dto.setCreator_id(task.getCreator_Id());
            dto.setDescription(task.getDescription());
            dto.setDuration(task.getDuration());
            dto.setReferenceVideo(task.getVideoReference());
            dto.setId(task.getId());
            user_DTO_tasks.add(dto);
        }

        return ResponseEntity.ok(user_DTO_tasks);
    }

    @PostMapping("/inspectTask")
    public ResponseEntity<TaskResponseDTO> inspectTask(@RequestBody Long id, HttpSession activeSession) {
        if (cookiesService.getDeleteTasksMode(activeSession)) {
            cookiesService.setActiveTaskId(activeSession, 0);
            return deleteTaskById(id);
        }
        else{
            cookiesService.setActiveTaskId(activeSession, id);
            return inspectTaskById(id);
        }
    }

    @GetMapping("/getCurrentTask")
    public ResponseEntity<TaskResponseDTO> getCurrentTask(HttpSession activeSession) {
        return inspectTaskById(cookiesService.getActiveTaskId(activeSession));
    }
    

    private ResponseEntity<TaskResponseDTO> inspectTaskById(long id){
        Task task = taskService.getTaskByID(id);
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setCreator_id(task.getCreator_Id());
        dto.setTaskname(task.getTaskname());
        dto.setDescription(task.getDescription());
        dto.setDuration(task.getDuration());
        dto.setReferenceVideo(task.getVideoReference());

        return ResponseEntity.ok(dto);
        
    }
    
    private ResponseEntity<TaskResponseDTO> deleteTaskById(long id) {
        taskService.deleteUserTask(id);
        return null;
    }
    
}
