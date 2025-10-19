package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.dto.TaskResponseDTO;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

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




@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService, UserService userService){
        this.taskService = taskService;
    }

    @PostMapping("/unvalidatedCreateTask")
    public ResponseEntity<Task> createUnvalidatedTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        return ResponseEntity.ok(taskService.saveUserTask(taskRequestDTO.getTaskname(), taskRequestDTO.getDescription(), taskRequestDTO.getDuration(), taskRequestDTO.getReference_video(), (long) 1));
    }    

    @PostMapping("/createTask")
    public ResponseEntity<Boolean> createTask(@RequestBody TaskRequestDTO taskRequestDTO, HttpSession activeSession) {
        return ResponseEntity.ok(taskService.createUserTask(taskRequestDTO.getTaskname(), taskRequestDTO.getDescription(), taskRequestDTO.getDuration(), taskRequestDTO.getReference_video(), (long) activeSession.getAttribute("activeUserId")));
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
            dto.setId(task.getId());
            user_DTO_tasks.add(dto);
        }
        setDeleteModeFalse(activeSession);

        return ResponseEntity.ok(user_DTO_tasks);
    }

    @PutMapping("/setDeleteMode")
    public ResponseEntity<Boolean> setDeleteMode(HttpSession activeSession) {
        if ((boolean) activeSession.getAttribute("deleteMode")){
            setDeleteModeFalse(activeSession);
        }     
        else{
            setDeleteModeTrue(activeSession);
        }
        
        return ResponseEntity.ok((boolean) activeSession.getAttribute("deleteMode"));
    }

    @PutMapping("/setDeleteModeToTrue")
    public void setDeleteModeTrue(HttpSession activeSession) {
        activeSession.setAttribute("deleteMode", true);
    }

    @PutMapping("/setDeleteModeToFalse")
    public void setDeleteModeFalse(HttpSession activeSession) {
        activeSession.setAttribute("deleteMode", false);
    }

    @PostMapping("/inspectTask")
    public ResponseEntity<TaskResponseDTO> postMethodName(@RequestBody Long id, HttpSession activeSession) {
        activeSession.setAttribute("currentTaskId", (long) 0);
        if ((boolean) activeSession.getAttribute("deleteMode")) {
            return deleteTaskById(id);
        }
        else{
            activeSession.setAttribute("currentTaskId", (long) id);
            return inspectTaskById(id);
        }
    }

    @GetMapping("/getCurrentTask")
    public ResponseEntity<TaskResponseDTO> getMethodName(HttpSession activeSession) {
        return inspectTaskById((long) activeSession.getAttribute("currentTaskId"));
    }
    
    

    private ResponseEntity<TaskResponseDTO> inspectTaskById(long id){
        Task task = taskService.getTaskByID(id);
        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setCreator_id(task.getCreator_Id());
        dto.setTaskname(task.getTaskname());
        dto.setDescription(task.getDescription());
        dto.setDuration(task.getDuration());
        dto.setReference_video(task.getVideoReference());

        return ResponseEntity.ok(dto);
        
    }
    
    private ResponseEntity<TaskResponseDTO> deleteTaskById(long id) {
        taskService.deleteUserTask(id);
        return null;
    }
    
    
    
}
